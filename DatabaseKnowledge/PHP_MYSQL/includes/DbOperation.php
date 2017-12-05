<?php
 
class DbOperation
{
 
    private $con;
	private $conn;

    function __construct()
    {

        require_once dirname(__FILE__) . '/DbConnect.php';
 

        $db = new DbConnect();
 
        $this->con = $db->connect();
		
    }
	

	function addUser($username, $email, $password){
		
		$stmt1 = $this->con->prepare("SELECT * FROM login WHERE email = ?");
		$stmt1->bind_param("s", $email);
		if($stmt1->execute())
			$stmt1->bind_result($us, $em, $pw);
		else
			return 2;
		
		$users = array(); 
		
		while($stmt1->fetch()){
			$user  = array();
			$user['username'] = $us; 
			$user['email'] = $em; 
			$user['password'] = $pw; 
			
			array_push($users, $user); 
		}
		$size = sizeof($users);
		if($size != 0)
		{
			return 1;
		}
		
		
		$stmt = $this->con->prepare("INSERT INTO login (username, email, password) VALUES (?, ?, ?)");
		$stmt->bind_param("sss", $username, $email, $password);
		if($stmt->execute())
			return 0; 
		return 2; 
	}

	function authUser($email, $password){
		$stmt = $this->con->prepare("SELECT * FROM login WHERE email = ? AND password = ?");
		$stmt->bind_param("ss", $email, $password);
		if($stmt->execute())
			$stmt->bind_result($username, $email, $password);
		else
			return false;
		
		$users = array(); 
		
		while($stmt->fetch()){
			$user  = array();
			$user['username'] = $username; 
			$user['email'] = $email; 
			$user['password'] = $password; 
			
			array_push($users, $user); 
		}
		$size = sizeof($users);
		if($size > 0)
		{
			return true;
		}
		else
		{
			return false;
		}

		
	}	
	
	

	function getUsers(){
		$stmt = $this->con->prepare("SELECT username, email, password FROM login");
		$stmt->execute();
		$stmt->bind_result($username, $email, $password);
		
		$users = array(); 
		
		while($stmt->fetch()){
			$user  = array();
			$user['username'] = $username; 
			$user['email'] = $email; 
			$user['password'] = $password; 
			
			array_push($users, $user); 
		}
		
		return $users; 
	}
	

	function updateUser($username, $email, $password){
		$stmt = $this->con->prepare("UPDATE login SET username = ?, password = ? WHERE email = ?");
		$stmt->bind_param("sss", $username, $email, $password);
		if($stmt->execute())
			return true; 
		return false; 
	}
	
	
	
	function deleteUser($email){
		$stmt = $this->con->prepare("DELETE FROM login WHERE email = ? ");
		$stmt->bind_param("s", $email);
		if($stmt->execute())
			return true; 
		
		return false; 
	}
}
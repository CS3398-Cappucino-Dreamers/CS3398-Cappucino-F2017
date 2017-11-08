<?php
 
class DbOperation
{
    //Database connection link
    private $con;
 
    //Class constructor
    function __construct()
    {
        //Getting the DbConnect.php file
        require_once dirname(__FILE__) . '/DbConnect.php';
 
        //Creating a DbConnect object to connect to the database
        $db = new DbConnect();
 
        //Initializing our connection link of this class
        //by calling the method connect of DbConnect class
        $this->con = $db->connect();
    }
	
	/*
	* The create operation
	* When this method is called a new record is created in the database
	* May change database to have a fist/last name too. Guid will be added server side later.
	*/
	function addUser($username, $email, $password, $guid){
		$stmt = $this->con->prepare("INSERT INTO login (username, email, password, guid) VALUES (?, ?, ?, ?)");
		$stmt->bind_param("ssss", $username, $email, $password, $guid);
		if($stmt->execute())
			return true; 
		return false; 
	}

	/*
	* The read operation
	* When this method is called it is returning all the existing record of the database
	* Not useful for app in this state.
	*/
	function getUsers(){
		$stmt = $this->con->prepare("SELECT username email, password, guid FROM login");
		$stmt->execute();
		$stmt->bind_result($username, $email, $password, $guid);
		
		$users = array(); 
		
		while($stmt->fetch()){
			$user  = array();
			$user['username'] = $username; 
			$user['email'] = $email; 
			$user['password'] = $password; 
			$user['guid'] = $guid;
			
			array_push($users, $user); 
		}
		
		return $users; 
	}
	
	/*
	* The update operation
	* When this method is called the record with the given guid is updated with the new given values
	* May not allow updating email? Also the user will not know their guid.
	*/
	function updateUser($username, $email, $password, $guid){
		$stmt = $this->con->prepare("UPDATE login SET username = ?, email = ?, password = ? WHERE guid = ?");
		$stmt->bind_param("ssss", $username, $email, $password, $guid);
		if($stmt->execute())
			return true; 
		return false; 
	}
	
	
	/*
	* The delete operation
	* When this method is called record is deleted for the given id
	* May not be useful for app.
	*/
	function deleteUser($guid){
		$stmt = $this->con->prepare("DELETE FROM login WHERE guid = ? ");
		$stmt->bind_param("s", $guid);
		if($stmt->execute())
			return true; 
		
		return false; 
	}
}
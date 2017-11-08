<?php
// CRUD(Create,Replace,Update,Delete) operations occuring in this file

// Class DbOperation
class DbOperation
{
	//Database connecting link
	private $con;

	//Class constructor
	function __construct()
	{
		//Getting the DbConnect.php file
		//require -- You have to have the file, otherwise code can't run
		require_once dirname(__FILE__) . '/DbConnect.php';

		//Creating a DbConnect object to connect to the database
		//We defined the class DbConnect
		$db = new DbConnect();

		//Initializing our connection link of this class
		//by calling the method connect of the DbConnect class
		$this->con = $db->connect();
	}

	
	/*
	* The create operation
	* When this method is called a new record(Row) is created in the database
	*/
	function createHero($name, $realname, $rating, $teamaffiliation){
		// from mysqli.. prepares a statement for executing.. takes in SQL Query(String)
		// prepare returns an instnace of mysqli_stmt
		// http://php.net/manual/en/mysqli.quickstart.prepared-statements.php
		$stmt = $this->con->prepare("INSERT INTO heroes (name, realname, rating, teamaffiliation) VALUES(?,?,?,?)");
		// Bind variables for the parameter markers in the SQL statement that was passed to mysqli_prepare(). 
		$stmt->bind_param("ssis", $name, $realname, $rating, $teamaffiliation);


		if($stmt->execute()){
			echo "Execute Passed";
			return true;
		}
		return false;

	}

	/*
	* The read operation
	* When this method is called it is returning all the existing record of the database
	*/

	function getHeroes(){
		$stmt = $this->con->prepare("SELECT id, name, realname, rating, teamaffiliation FROM heroes");
		$stmt->execute();
		// puts result of execute in the following variables.
		$stmt->bind_result($id, $name, $realname, $rating, $teamaffiliation);

		$heroes = array();

		// While(Success. Data has been fetched)
		while($stmt->fetch()){
			$hero = array();
			$hero['id'] = $id;
			$hero['name'] = $name;
			$hero['realname'] = $realname;
			$hero['rating'] = $rating;
			$hero['teamaffiliation'] = $teamaffiliation;

			array_push($hereos, $hero); // pushes a row into the $hereos array. Making it 2D
		}

		return $heroes // 2D array? rows and columns of the database
	}

	/*
	* The delete operation
	* When this method is called record is deleted for the given id
	*/

	function deleteHero($id){
		$stmt = $this->con->prepare("DELETE FROM heroes WHERE id = ?");
		$stmt->bind_param("i", $id);
		if($stmt->execute())
			return true;
		return false;
	}

}





?>
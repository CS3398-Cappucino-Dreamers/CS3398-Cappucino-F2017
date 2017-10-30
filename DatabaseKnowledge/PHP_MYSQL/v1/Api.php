<?php

// getting the dboperation class we defined
include_once '../includes/DbOperation.php';

//function validating all the parameters are available
//we will pass the required parameters to this function
function isTheseParametersAvailable($params){
	//assuming all parameters are available.
	$available = true;
	$missingparams = "";

	// Checks each of the params in $_POST.. I'm assuming $param is a String (key)
	foreach($params as $param){
		if(!isset($_POST[$param]) || strlen($_POST[$param]) <=0){
			$available = false;
			$missingparams = $missingparams . ", " . $param;
		}
	}

	// if parameters are missing
	if(!$available){
		$response = array();
		$response['error'] = true;
		$response['message'] = 'Parameters ' . substr($missingparams, 1, strlen($missingparams)) . 'missing';
	

		// displaying error, Returns a string containing the JSON representation of the supplied value.
		echo json_encode($response);

		die();
	}


}

//an array to display response
$response = array();

// if it is an api call
// that means a get parameter named api call is set in the URL
// and with this parameter we are concluding 
if(isset($_GET['apicall'])){

	switch($_GET['apicall']){
		case 'createhero':
		//first check the parameters required for this request are available or not
		isTheseParametersAvailable(array('name', 'realname', 'rating', 'teamaffiliation'));

		//creating a new dboperation object
		$db = new DbOperation();

		//Creating a new record in the database
		$result = $db->createHero($_POST['name'], $_POST['realname'], $_POST['rating'], $_POST['teamaffiliation']);


		// if the record is created adding success to response
		if($result){
			//record is created means there is no error
			$response['error'] = false;

			//in message we have a success message
			$response['message'] = 'Hero added successfully';

			//and we are getting all the heroes from the database in the response
			$response['heroes'] = $db->getHeroes();
		}
		else{

			//if record is not added that means there is an error
			$response['error'] = true;

			//and we have the error message
			$response['message'] = 'some error occurred please try again';
		}
		break;


		//the READ operation, if the call is getheroes
		case 'getHeroes':
			$db = new DbOperation();
			$response['error'] = false;
			$response['message'] = 'Request successfully completed';
			$response['heroes'] = $db->getHeroes();
		break;


		//the UPDATE operation
		case 'updatehero':
			isTheseParametersAvailable(array('id','name', 'realname', 'rating', 'teamaffiliation'));
			$db = new DbOperation();
			$result = $db->updateHero($_POST['id'], $_POST['name'], $_POST['realname'], $_POST['rating'], $_POST['teamaffiliation']);

			if($result){
				$response['error'] = false;
				$response['message'] = 'Hero updated successfully';
				$response['heroes'] = $db->getHeroes();
			}else{
				$response['error'] = true;
				$response['message'] = 'Some error occured please try again';
			}
			break;

		//The DELETE operation
		case 'deletehero':

			//for the delete operation we are getting a GET parameter from the url having the id of the record
			if(isset($_GET['id'])){
				$db = new DbOperation();
				if($db->delteHero($_GET['id'])){
					$response['error'] = false;
					$response['message' = 'Hero deleted successfully';
					$response['heroes'] = $db->getHeroes();
				}
			}
	}

}





}



?>
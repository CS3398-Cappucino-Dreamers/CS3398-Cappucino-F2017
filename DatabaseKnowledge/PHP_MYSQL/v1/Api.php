<?php 


	require_once '../includes/DbOperation.php';

	//function validating all the paramters are available
	//we will pass the required parameters to this function 
	function isTheseParametersAvailable($params){
		//assuming all parameters are available 
		$available = true; 
		$missingparams = ""; 
		
		foreach($params as $param){
			if(!isset($_POST[$param]) || strlen($_POST[$param])<=0){
				$available = false; 
				$missingparams = $missingparams . ", " . $param; 
			}
		}
		
		//if parameters are missing 
		if(!$available){
			$response = array(); 
			$response['error'] = true; 
			$response['message'] = 'Parameters ' . substr($missingparams, 1, strlen($missingparams)) . ' missing';
			
			//displaying error
			echo json_encode($response);
			
			//stopping further execution
			die();
		}
	}
	
	//an array to display response
	$response = array();
	
	//if it is an api call 
	//that means a get parameter named api call is set in the URL 
	//and with this parameter we are concluding that it is an api call
	if(isset($_GET['apicall'])){
		
		switch($_GET['apicall']){
			
			//the CREATE operation
			//if the api call value is 'addUser'
			//we will create a record in the database
			case 'addUser':
				//first check the parameters required for this request are available or not 
				isTheseParametersAvailable(array('username','email','password'));
				//$email = 'email';
				if ( !preg_match('/[A-Za-z0-9]*@[A-Za-z]*[.][A-Za-z]{3}/', $_POST['email']) )
				{
					$response['error'] = true; 
					$response['message'] = 'Not a vaid email';
				}
				else
				{
					$db = new DbOperation();
				
					$result = $db->addUser(
						$_POST['username'],
						$_POST['email'],
						$_POST['password']
					);
					
					switch($result){
						case 0:
							$response['error'] = false; 
							$response['message'] = 'Account created successfully';
							break;
						case 1:
							$response['error'] = true; 
							$response['message'] = 'Account already exists for email';
							break;
						case 2:
							$response['error'] = true; 
							$response['message'] = 'connection error';
							break;
						default:
							$response['error'] = true; 
							$response['message'] = 'some other error';
							break;
					}
					
				}

				
			break; 
			
			case 'authUser':
				isTheseParametersAvailable(array('email','password'));
				
				$db = new DbOperation();
				
				$result = $db->authUser(
					$_POST['email'],
					$_POST['password']
				);
				

				if($result){
					$response['error'] = false; 
					$response['message'] = 'User authenticated successfully';

				}else{

					$response['error'] = true; 
					$response['message'] = 'Username or password invalid';
				}
			break; 
			
			
			//the READ operation
			//if the call is getUsers
			case 'getUsers':
				$db = new DbOperation();
				$response['error'] = false; 
				$response['message'] = 'Request successfully completed';
				$response['users'] = $db->getUsers();
			break; 
			

			//the UPDATE operation
			case 'updateUser':
				isTheseParametersAvailable(array('username','email','password'));
				$db = new DbOperation();
				$result = $db->updateUser(
					$_POST['username'],
					$_POST['email'],
					$_POST['password']
				);
				
				if($result){
					$response['error'] = false; 
					$response['message'] = 'User updated successfully';
				}else{
					$response['error'] = true; 
					$response['message'] = 'Some error occurred please try again';
				}
			break; 
			
			//the delete operation
			case 'deleteUser':

				//for the delete operation we are getting a GET parameter from the url having the id of the record to be deleted
				if(isset($_GET['email'])){
					$db = new DbOperation();
					if($db->deleteUser($_GET['email'])){
						$response['error'] = false; 
						$response['message'] = 'User deleted successfully';
					}else{
						$response['error'] = true; 
						$response['message'] = 'Some error occurred please try again';
					}
				}else{
					$response['error'] = true; 
					$response['message'] = 'Nothing to delete, provide an email please';
				}
			break; 
		}
		
	}else{
		//if it is not api call 
		//pushing appropriate values to response array 
		$response['error'] = true; 
		$response['message'] = 'Invalid API Call';
	}
	
	//displaying the response in json structure 
	echo json_encode($response);
	
	

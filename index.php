<?php
    $servername = "localhost";
    $username = "root";
    $password = "";
    $dbname = "webdb";

    // Create connection
    $conn = new mysqli($servername, $username, $password, $dbname);
    // Check connection
    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    }

    $sql = "INSERT INTO userid (id, name, position) VALUES ('SRD005','Gina','Officer')";
    if($conn->query($sql) === TRUE){
        echo "New record has been inserted successfully";
    } else{
        echo "Error : " . $sql . "<br>" . $conn->error;
    }

    $conn->close();
?>

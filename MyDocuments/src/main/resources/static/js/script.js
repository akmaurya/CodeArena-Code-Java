$(document).ready(function() {
  // Handle form submission
  $("#personForm").submit(function(event) {
    event.preventDefault(); // Prevent the form from submitting normally
    var formData = {
      name: $("#name").val(),
      age: $("#age").val(),
      gender: $("#gender").val(),
      photo: $("#photo").val()
    };

    // Send POST request to the server
    $.ajax({
      type: "POST",
      url: "/persons",
      data: JSON.stringify(formData),
      contentType: "application/json",
      success: function(response) {
        // Handle success response
        console.log("Person saved successfully:", response);
        // Reset the form
        $("#name").val("");
        $("#age").val("");
        $("#gender").val("");
        // Refresh the person table
        getPersonList();
      },
      error: function(error) {
        // Handle error response
        console.error("Error saving person:", error);
      }
    });
  });

  // Fetch and display person list
  getPersonList();

  function getPersonList() {
    $.ajax({
      type: "GET",
      url: "/persons",
      success: function(response) {
        // Clear the table body
        $("#personTable tbody").empty();
        // Iterate through the response and append rows to the table
        response.forEach(function(person) {
          var row = "<tr><td>" + person.name + "</td><td>" + person.age + "</td><td>" + person.gender + "</td><td><button class='btn btn-danger btn-sm' onclick='test()'>Delete</button></td></tr>";
          $("#personTable tbody").append(row);
        });
      },
      error: function(error) {
        console.error("Error fetching person list:", error);
      }
    });
  }

  
  // Handle person deletion
  function deletePerson(id) {
	alert("delete working");
    if (confirm("Are you sure you want to delete this person?")) {
      $.ajax({
        type: "DELETE",
        url: "/persons/" + id,
        success: function(response) {
          // Handle success response
          console.log("Person deleted successfully:", response);
          // Refresh the person table
          getPersonList();
        },
        error: function(error) {
          // Handle error response
          console.error("Error deleting person:", error);
        }
      });
    }
  }
});

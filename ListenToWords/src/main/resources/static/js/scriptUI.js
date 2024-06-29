// JSON data
        var jsonData = {
            "id": 1,
            "name": "John Doe",
            "dob": "1990-01-01",
            "gender": "Male",
            "contactNo": "+1 123-456-7890",
            "documents": [
                {
                    "id": 1,
                    "name": "Passport",
                    "details": [
                        {
                            "name": "Passport Number",
                            "infoData": "ABC123XYZ"
                        },
                        {
                            "name": "Issue Date",
                            "infoData": "2010-05-10"
                        },
                        {
                            "name": "Expiry Date",
                            "infoData": "2020-05-10"
                        }
                    ]
                },
                {
                    "id": 2,
                    "name": "Driver's License",
                    "details": [
                        {
                            "name": "License Number",
                            "infoData": "DL-12345-67890"
                        },
                        {
                            "name": "Issue Date",
                            "infoData": "2012-08-20"
                        }
                    ]
                }
            ]
        };

        // Display JSON data
        document.getElementById('jsonData').textContent = JSON.stringify(jsonData, null, 2);

        // Load user information
        document.getElementById('name').value = jsonData.name;
        document.getElementById('dob').value = jsonData.dob;
        document.getElementById('gender').value = jsonData.gender;
        document.getElementById('contactNo').value = jsonData.contactNo;

        // Load documents
        var documentsContainer = document.getElementById('documentsContainer');
        jsonData.documents.forEach(function(document) {
            var documentElement = createDocumentElement(document);
            documentsContainer.appendChild(documentElement);
        });

        // Add document button click event
        document.getElementById('addDocumentButton').addEventListener('click', function() {
            var newDocumentId = jsonData.documents.length + 1;
            var newDocument = {
                "id": newDocumentId,
                "name": "",
                "details": []
            };

            var newDocumentElement = createDocumentElement(newDocument);
            documentsContainer.appendChild(newDocumentElement);
        });

        // Save button click event
        document.getElementById('saveButton').addEventListener('click', function() {
            // Update user information
            jsonData.name = document.getElementById('name').value;
            jsonData.dob = document.getElementById('dob').value;
            jsonData.gender = document.getElementById('gender').value;
            jsonData.contactNo = document.getElementById('contactNo').value;

            // Update documents
            var documentElements = documentsContainer.getElementsByClassName('document');
            jsonData.documents = Array.from(documentElements).map(function(element) {
                var documentId = parseInt(element.dataset.documentId, 10);
                var documentName = element.querySelector('.document-name').value;
                var detailElements = element.getElementsByClassName('document-detail');
                var details = Array.from(detailElements).map(function(detailElement) {
                    var name = detailElement.querySelector('.detail-name').value;
                    var infoData = detailElement.querySelector('.detail-info-data').value;
                    return {
                        "name": name,
                        "infoData": infoData
                    };
                });

                return {
                    "id": documentId,
                    "name": documentName,
                    "details": details
                };
            });

            // Display updated JSON data
            document.getElementById('jsonData').textContent = JSON.stringify(jsonData, null, 2);
        });

        // Helper function to create a document element
        function createDocumentElement(document) {
            var documentElement = document.createElement('div');
            documentElement.className = 'document';
            documentElement.dataset.documentId = document.id;

            var nameLabel = document.createElement('label');
            nameLabel.textContent = 'Name:';
            var nameInput = document.createElement('input');
            nameInput.type = 'text';
            nameInput.className = 'document-name';
            nameInput.value = document.name;
            documentElement.appendChild(nameLabel);
            documentElement.appendChild(nameInput);

            document.details.forEach(function(detail) {
                var detailElement = createDetailElement(detail);
                documentElement.appendChild(detailElement);
            });

            var addDetailButton = document.createElement('button');
            addDetailButton.textContent = 'Add Detail';
            addDetailButton.addEventListener('click', function() {
                var newDetailElement = createDetailElement({
                    "name": "",
                    "infoData": ""
                });
                documentElement.insertBefore(newDetailElement, addDetailButton);
            });
            documentElement.appendChild(addDetailButton);

            return documentElement;
        }

        // Helper function to create a detail element
        function createDetailElement(detail) {
            var detailElement = document.createElement('div');
            detailElement.className = 'document-detail';

            var nameLabel = document.createElement('label');
            nameLabel.textContent = 'Name:';
            var nameInput = document.createElement('input');
            nameInput.type = 'text';
            nameInput.className = 'detail-name';
            nameInput.value = detail.name;
            detailElement.appendChild(nameLabel);
            detailElement.appendChild(nameInput);

            var infoDataLabel = document.createElement('label');
            infoDataLabel.textContent = 'Info Data:';
            var infoDataInput = document.createElement('input');
            infoDataInput.type = 'text';
            infoDataInput.className = 'detail-info-data';
            infoDataInput.value = detail.infoData;
            detailElement.appendChild(infoDataLabel);
            detailElement.appendChild(infoDataInput);

            return detailElement;
        }
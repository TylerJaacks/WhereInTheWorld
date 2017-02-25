// Global Variables
var lats = []
var lons = []
var articles = []

var jsonString = ""

// Opens and Reads Files
var openFile = function(event) {
    var input = event.target;
    var reader = new FileReader()
        
    reader.onload = function() {
        var text = reader.result;
        var node = document.getElementById('output')
          
        node.innerText = text;

        jsonString = reader.result;    

        var jsonObject = JSON.parse(jsonString);

        for (var i = 0; i < jsonObject.lat.length; i++) { 
            lats[i] = jsonObject.lat[i]
            console.log(lats[i]); 
        }

        for (var i = 0; i < jsonObject.lons.length; i++) { 
            lons[i] = jsonObject.lat[i]
            console.log(lons[i]); 
        }
    };
    
    reader.readAsText(input.files[0])
};

// function parseJSON() {
//     var jsonObject = JSON.parse(jsonString);

//     for (var i = 0; i < jsonObject.lat.length; i++) { 
//         lats[i] = jsonObject.lat[i]
//         console.log(lats[i]); 
//     }

//     for (var i = 0; i < jsonObject.lons.length; i++) { 
//         lons[i] = jsonObject.lat[i]
//         console.log(lons[i]); 
//     }
// }
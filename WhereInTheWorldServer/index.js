// Global Variables
var lats = []
var lons = []
var articles = []

var rawJSON = ""

// Opens and Reads Files
var openFile = function(event) {
    var input = event.target;
    var reader = new FileReader()
        
    reader.onload = function() {
        var text = reader.result;
        var node = document.getElementById('output')
          
        node.innerText = text;

        rawJSON = reader.result;    
    };
    
    reader.readAsText(input.files[0])


};

function parseJSON() {
    var content = JSON.parse(rawJSON)

    console.log(content)
}
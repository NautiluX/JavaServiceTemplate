var testGet = function() {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'calc/sum');
    xhr.onload = function() {
        if (xhr.status === 200) {
            alert('response: ' + xhr.responseText);
        }
        else {
            alert('Request failed.  Returned status of ' + xhr.status);
        }
    };
    xhr.send();
};

var getSum = function() {
    var data = {
        inputValues: getInput()
    }
    var xhr = new XMLHttpRequest();
    xhr.open('POST', 'calc/sum');
    xhr.setRequestHeader('Content-Type', 'application/json');
    
    xhr.onload = function() {
        if (xhr.status === 200) {
            var data = JSON.parse(xhr.responseText);
            document.getElementById("result").innerHTML = data.result;
        }
        else {
            alert('Request failed.  Returned status of ' + xhr.status);
        }
    };
    xhr.send(JSON.stringify(data));
};

var getInput = function() {
    var inputString = document.getElementById("input").value;
    var inputArray = inputString.split(",");
    var inputNumbers = convertInput(inputArray);
    return inputNumbers;
}

var convertInput = function(inputArray) {
    var inputNumbers = Array();
    inputArray.forEach(function(inputPart){
        inputNumbers.push(parseFloat(inputPart));
    });
    return inputNumbers;
}
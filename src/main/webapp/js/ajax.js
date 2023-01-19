/**
 * 
 */
 
function getData() {
    const xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            const data = JSON.parse(xhr.responseText);
            console.log(data)
            const table = document.getElementById("dataTable");
            for (var i = 0; i < data.length; i++) {
                var row = table.insertRow();
                var cell1 = row.insertCell(0);
                var cell2 = row.insertCell(1);
                var cell3 = row.insertCell(2);
                var cell4 = row.insertCell(3);
                var cell5 = row.insertCell(4);
                //var cell6 = row.insertCell(5);
                cell1.innerHTML = i+1;
                cell2.innerHTML = data[i].Designation;
                cell3.innerHTML = data[i].Prix;
                cell4.innerHTML = data[i].Quantite;
                cell5.innerHTML = "<form action='/gestionStock/article' method='POST'><input type='hidden' value="+ data[i].id +" name='id' /><input type='hidden' value='del' name='status'/><button class='btn btn-danger'>Supprimer</button> <a href='/gestionStock/article?idArticle="+data[i].id+"' class='btn btn-primary'>Modifier</a> </form>"
                //cell6.innerHTML = "<a href='/gestionStock/article?idArticle="+data[i]+"' class='btn btn-primary'>Modifier</a>"
            }
        }
    };
    xhr.open("GET", "http://127.0.0.1:8080/gestionStock/article", true);
    xhr.send();
}
 
 
 
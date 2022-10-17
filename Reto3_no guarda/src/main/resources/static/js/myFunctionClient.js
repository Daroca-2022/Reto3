
var myURLClient = 'https://g8ae90527c5e62a-reto1.adb.us-phoenix-1.oraclecloudapps.com/ords/admin/client/client';


function getClients() {
//funcion GET
    $.ajax({

        url : "api/Client/all",
        type : 'GET',
        dataType : 'json',
        success : function(clients) {

            let cs=clients;
            $("#clients").empty();

            let k =""
            k += "<table class='table'>";
            k += "<thead class='thead-dark'>";
            k += "<tr >";
            k += "<th>" + "idClient" + "</th>";
            k += "<th>" + "email" + "</th>";
            k += "<th>" + "password" + "</th>";
            k += "<th>" + "age" + "</th>";
            k += "<th>" + "Borrar" + "</th>";
            k += "<th>" + "Actualizar" + "</th>";
            k += "</tr>";
            k += "</thead>";

            for(let i=0;i<cs.length;i++){

                /*
                let k=cs[i].idClient+" "+cs[i].name+" "+cs[i].email+" "+cs[i].age+"<button onclick='deleteClient("+cs[i].id+")'>Borrar</button>";
                k+="<button onclick='getDetailClient("+cs[i].id+")'>Actualizar</button><br>";
                */
                $("#clients").append(k);

            }
        },


        error : function(xhr, status) {
            alert('ha sucedido un problema');
        }
    });
}

function getClientInfo(){
    let idClient=$("#idClient").val();
    let nameClient=$("#nameClient").val();
    let emailClient=$("#emailClient").val();
    let ageClient=$("#ageClient").val();


    let client={
        id:idClient,
        name:nameClient,
        email:emailClient,
        age:ageClient
    };
    return client;
}
//function para limpiar los inputs
function cleanInputs(){
    $("#idClient").val("");
    $("#nameClient").val("");
    $("#emailClient").val("");
    $("#ageClient").val("");
}

function saveClient(){
    let data=getClientInfo();
    let dataToSend=JSON.stringify(data);
    console.log(data);
    console.log(dataToSend);
    
    $.ajax({

        url : myURLClient,
        type : 'POST',
        contentType : 'application/json',
        data:dataToSend,

        success : function(clients) {
            cleanInputs();
            getClients();
        },


        error : function(xhr, status) {
            alert('ha sucedido un problema'); 
        }
    });
}

function updateClient(){
    let data=getClientInfo();
    let dataToSend=JSON.stringify(data);
    console.log(data);
    console.log(dataToSend);
    
    $.ajax({

        url : myURLClient,
        type : 'PUT',
        contentType : 'application/json',
        data:dataToSend,

        success : function(clients) {
            cleanInputs();
            getClients();
        },


        error : function(xhr, status) {
            alert('ha sucedido un problema'); 
        }
    });
}

function deleteClient(idClient){
    
    let data={id:idClient};
    let dataToSend=JSON.stringify(data);
    
    $.ajax({

        url : myURLClient,
        type : 'DELETE',
        contentType : 'application/json',
        data:dataToSend,

        success : function(clients) {
            cleanInputs();
            getClients();
        },

        // código a ejecutar si la peticion falla;
        error : function(xhr, status) {
            alert('ha sucedido un problema'); 
        }
    });
}

function getDetailClient(idClient){
    
    $.ajax({

        url : myURLClient+"/"+idClient,
        type : 'GET',
        dataType : 'json',

        success : function(clients) {
            let cs=clients.items;
            
            $("#idClient").val(cs[0].id);
            $("#nameClient").val(cs[0].name);
            $("#emailClient").val(cs[0].email);
            $("#ageClient").val(cs[0].age);
                  
        },


        error : function(xhr, status) {
            alert('ha sucedido un problema');
        }
    });
}
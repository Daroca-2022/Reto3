
//var myURLMachine = 'https://g8ae90527c5e62a-reto1.adb.us-phoenix-1.oraclecloudapps.com/ords/admin/machine/machine';
// la URL para la petición
function getMachines() {
//funcion GET
    $.ajax({
        // la URL para la petición
        url : "api/Machine/all",
        type : 'GET',
        dataType : 'json',
        success : function(machines) {
            let ms=machines;
            $("#machines").empty();

            let k =""
            k += "<table class='tb'>";
            k += "<tr>";
           // k += "<th class='hidden'>" + "Id" + "</th>";
            k += "<th>" + "Name" + "</th>";
            k += "<th>" + "Brand" + "</th>";
            k += "<th>" + "Year" + "</th>";
            k += "<th>" + "Categoría" + "</th>";
            k += "<th>" + "Description" + "</th>";
            k += "<th>" + "Borrar" + "</th>";
            k += "<th>" + "Actualizar" + "</th>";
            k += "</tr>";
            for(let i=0;i<ms.length;i++){
                k += "<tr>";
                k += "<th>" + ms[i].name + "</th>";
                k += "<th>" + ms[i].Brand + "</th>"
                k += "<th>" + ms[i].year + "</th>";
                "+ms[i].brand+" "+ms[i].year+" "+ms[i].description+"<button onclick='deleteMachine("+ms[i].id+")'>Borrar</button>";
                k+="<button onclick='getDetailMachine("+ms[i].id+")'>Actualizar</button><br>";
                $("#machines").append(k);
            }
            /*
            for(let i=0;i<ms.length;i++){
                let k=ms[i].name+" "+ms[i].brand+" "+ms[i].year+" "+ms[i].description+"<button onclick='deleteMachine("+ms[i].id+")'>Borrar</button>";
                k+="<button onclick='getDetailMachine("+ms[i].id+")'>Actualizar</button><br>";
                $("#machines").append(k);
            }*/
        },

            error : function(xhr, status) {
            alert('ha sucedido un problema');
        }
    });
}

function getMachineInfo(){
    let idMachine=$("#idMachine").val();
    let nameMachine=$("#nameMachine").val();
    let brandMachine=$("#brandMachine").val();
    let yearMachine=$("#yearMachine").val();
    let categoryidMachine=$("#categoryIdMachine").val();



    let machine={
        id:idMachine,
        name:nameMachine,
        brand:brandMachine,
        year: yearMachine,
        category:categoryidMachine
        //category:{id:categoryidMachine},

    };
    return machine;
}

function cleanInputsMachines(){
    $("#idMachine").val("");
    $("#nameMachine").val("")
    $("#brandMachine").val("");
    $("#yearMachine").val("");
    $("#categoryIdMachine").val("");

}

function saveMachine(){
    let data=getMachineInfo();
    let dataToSend=JSON.stringify(data);
    console.log(data);
    console.log(dataToSend);
    
    $.ajax({
        url : "api/Machine/save",
        type : 'POST',
        contentType : 'application/json',
        data:dataToSend,

        success : function(machines) {
            cleanInputsMachines();
            getMachines();
        },


        error : function(xhr, status) {
            alert('ha sucedido un problema'); 
        }
    });
}

function updateMachine(){
    let data=getMachineInfo();
    let dataToSend=JSON.stringify(data);
    console.log(data);
    console.log(dataToSend);

    $.ajax({

        url : "api/Machine/update",
        type : 'PUT',
        contentType : 'application/json',
        data:dataToSend,

        success : function(machines) {
            cleanInputsMachines();
            getMachines();
        },


        error : function(xhr, status) {
            alert('ha sucedido un problema');
        }
    });
}

function deleteMachine(idMachine){
    
    let data={id:idMachine};
    let dataToSend=JSON.stringify(data);
    
    $.ajax({
       // url : myURLMachine+"/"+idMachine,
        url : "api/Machine"+"/"+idMachine,
        type : 'DELETE',
        contentType : 'application/json',
        data:dataToSend,

        success : function(machines) {
            cleanInputsMachines();
            getMachines();
        },


        error : function(xhr, status) {
            alert('ha sucedido un problema'); 
        }
    });
}

function getDetailMachine(idMachine){
console.log(idMachine);
    $.ajax({

        url : "api/Machine"+"/"+idMachine,
        type : 'GET',
        dataType : 'json',

        success : function(machines) {
            let ms=machines;
            
            $("#idMachine").val(ms.id);
            $("#nameMachine").val(ms.name);
            $("#brandMachine").val(ms.brand);
            $("#yearMachine").val(ms.year);
            $("#categoryIdMachine").val(ms.category);

                  
        },


        error : function(xhr, status) {
            alert('ha sucedido un problema');
        }
    });
}
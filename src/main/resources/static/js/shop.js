function pageLoad() {
    toastr.options = {
        "closeButton": true,
        "debug": false,
        "newestOnTop": false,
        "progressBar": true,
        "positionClass": "toast-bottom-right",
        "preventDuplicates": false,
        "onclick": null,
        "showDuration": "100",
        "hideDuration": "100",
        "timeOut": "3000",
        "extendedTimeOut": "3000",
        "showEasing": "swing",
        "hideEasing": "swing",
        "showMethod": "fadeIn",
        "hideMethod": "fadeOut"
    };
}

function orderProduct(element) {
    const url = window.location;

    const product = element.parentElement;
    const id = product.firstElementChild.innerHTML;

    const infoToast = toastr["info"]("Megrendelés leadása...");

    const sendData = {
        id: id
    }

    jQuery.ajax({
        async: true,
        type: "POST",
        contentType: "application/json",
        url: url,
        data: JSON.stringify(sendData),
        dataType: 'text',
        timeout: 30000,
        success: function (result) {
            if(result == "Done") {
                infoToast.remove();
                toastr["success"]("Megrendelés leadva.");
            } else {
                infoToast.remove();
                toastr["success"]("Megrendelést nem sikerült leadnunk.")
            }
        },
        error: function(error, result) {
            infoToast.remove();
            toastr["error"]("Megrendelés sikertelen.");
        }
    });
}
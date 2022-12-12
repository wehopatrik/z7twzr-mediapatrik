// Metódus az oldal betöltésekor fusson le
window.onload = pageLoad();

// toastr beállítása
function pageLoad() {
    toastr.options = {
        "closeButton": true,
        "debug": false,
        "newestOnTop": false,
        "progressBar": true,
        "positionClass": "toast-top-center",
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

// Rendelések lista betöltése
function loadOrderListContent() {
    var infoToast = toastr["info"]("Betöltés...");

    jQuery.ajax({
       type: "GET",
       url: "admin/order-list",
       data: { },
       success: function(data) {
           infoToast.remove();
           toastr["success"]("Betöltés sikeres.");
           $('#div-content').html(data);
       },
       error: function(error, result) {
           infoToast.remove();
           toastr["error"]("Betöltés sikertelen.");
       }
    });
}

// Rendelések lista betöltése
function loadProductListContent() {
    var infoToast = toastr["info"]("Betöltés...");

    jQuery.ajax({
        type: "GET",
        url: "admin/product-list",
        data: { },
        success: function(data) {
            infoToast.remove();
            toastr["success"]("Betöltés sikeres.");
            $('#div-content').html(data);
        },
        error: function(error, result) {
            infoToast.remove();
            toastr["error"]("Betöltés sikertelen.");
        }
    });
}
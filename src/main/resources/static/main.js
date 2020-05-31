$(document).ready(function () {

    $(".btn-start").click(function (event) {

        $(this).prop("disabled", true);

        // gets the closest table row, finds the row children with the class 'input-hidden' and returns an array of inputs
        var requestId = $(this).closest("tr").find(".input-hidden").attr("value");

        startRequest("#"+$(this).attr("id"), requestId);
    });

});

function startRequest(buttonId, requestId) {

    var body = {"requestId" : requestId}

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/api/period",
        data: JSON.stringify(body),
        cache: false,
        timeout: 600000,
        success: function (data) {

            var json = "Ajax Response: "
                + JSON.stringify(data, null, 4);

            console.log("SUCCESS : ", data);
            console.log("JSON : ", json);
            $(buttonId).prop("disabled", false);

        },
        error: function (e) {

            var json = "Ajax Response: "
                + e.responseText;

            console.log("ERROR : ", e);
            console.log("JSON : ", json);
            $(buttonId).prop("disabled", false);

        }
    });

}
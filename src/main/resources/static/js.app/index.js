var main ={
    init : function() {
        var _this = this;
        $('#btn-primary').on('click', function() {
            _this.save();
        })
    },
    save : function() {
        var data = {
            title: $('#title').val(),
            content: $('#content').val(),
            startDate: $('#startDate').val(),
            startTime: $('#startTime').val(),
            endDate: $('endDate').val(),
            endTime: $('endTime').val()
        };

        $.ajax({
            type: 'POST'
            url: '/calendar/register',
            dataType: 'json',
            contentType: 'application/json; charset=utr-8',
            data: JSON.stringify(data)
        }).done(function(){
            alert('일정이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};

main.init();

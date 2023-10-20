var TableDatatablesScroller = function () {


    var initTable11 = function () {
        var table = $('#sample_11');

        var oTable = table.dataTable({
            // scroller extension: http://datatables.net/extensions/scroller/
            serverSide: true,
            ordering: false,
            searching: false,
            ajax: function ( data, callback, settings ) {
                var out = [];
                for ( var i=data.start, ien=data.start+data.length ; i<ien ; i++ ) {
                    out.push( [ i+'-1', i+'-2', i+'-3', i+'-4', i+'-5' ] );
                }
     
                setTimeout( function () {
                    callback( {
                        draw: data.draw,
                        data: out,
                        recordsTotal: 5000000,
                        recordsFiltered: 5000000
                    } );
                }, 50 );
            }
            ,
            scrollY: 400,//สกรอบาร์
            scroller: {//สกรอบาร์
                loadingIndicator: true
            }
        });
    }


    return {

        //main function to initiate the module
        init: function () {

            if (!jQuery().dataTable) {
                return;
            }

            initTable11();
        }

    };

}();

jQuery(document).ready(function() {
    TableDatatablesScroller.init();
});


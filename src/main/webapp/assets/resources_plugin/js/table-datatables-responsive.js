var TableDatatablesResponsive = function () {

    var initTable1 = function () {
        var table = $('#sample_8');

        var oTable = table.dataTable({            
            // setup responsive extension: http://datatables.net/extensions/responsive/
            responsive: {
                details: {
                   
                }
            },
            
            bFilter: false, //ปิดการค้นหา
            bLengthChange: false,//ปิดการเลือกจำนวนข้อมูลต่อหน้า
            bSort : false//ปิดการเรียงลำดับ
        });
    }
    
    var initTable10 = function () {
        var table = $('#sample_10');

        var oTable = table.dataTable({            
            bFilter: false, //ปิดการค้นหา
            bLengthChange: false,//ปิดการเลือกจำนวนข้อมูลต่อหน้า
            bSort : false//ปิดการเรียงลำดับ
        });
    }

    var initTable2 = function () {
        var table = $('#sample_9');

        var oTable = table.dataTable({
            // setup buttons extentension: http://datatables.net/extensions/buttons/
            buttons: [//ปุ่มที่แสดงบนหัวตาราง
                { extend: 'print', className: 'btn dark btn-outline' },
                { extend: 'pdf', className: 'btn green btn-outline' },
                { extend: 'csv', className: 'btn purple btn-outline ' }
            ],

            // setup responsive extension: http://datatables.net/extensions/responsive/
            responsive: {
                details: {
                    type: 'column',
                    target: 'tr'
                }
            },
            columnDefs: [ {
                className: 'control',
                orderable: false,
                targets:   0
            } ],

            order: [ 1, 'asc' ],
            
            // pagination control
            "lengthMenu": [
                [5, 10, 15, 20, -1],
                [5, 10, 15, 20, "All"] // จำนวนข้อมูลที่แสดงต่อหน้า สำหรับให้เลือก
            ],
            // set the initial value
            "pageLength": 10,//จำนวนข้อมูลที่แสดงต่อหน้า
            "pagingType": 'bootstrap_extended', // รูปแบบการแสดงจำนวนหน้าให้เลือก ถ้าไม่ใส่จะเป็น แบบปกติ

//dom คือ ปุ่มที่แสดงบนหัวตาราง
            "dom": "<'row' <'col-md-12'B>><'row'<'col-md-6 col-sm-12'l><'col-md-6 col-sm-12'f>r><'table-scrollable't><'row'<'col-md-5 col-sm-12'i><'col-md-7 col-sm-12'p>>", // horizobtal scrollable datatable

            // Uncomment below line("dom" parameter) to fix the dropdown overflow issue in the datatable cells. The default datatable layout
            // setup uses scrollable div(table-scrollable) with overflow:auto to enable vertical scroll(see: assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.js). 
            // So when dropdowns used the scrollable div should be removed. 
            //"dom": "<'row' <'col-md-12'T>><'row'<'col-md-6 col-sm-12'l><'col-md-6 col-sm-12'f>r>t<'row'<'col-md-5 col-sm-12'i><'col-md-7 col-sm-12'p>>",
        });
    }    

    return {

        //main function to initiate the module
        init: function () {

            if (!jQuery().dataTable) {
                return;
            }

            initTable1();
            initTable2();
            initTable10();
        }

    };

}();

jQuery(document).ready(function() {
    TableDatatablesResponsive.init();
});
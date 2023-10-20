var TableDatatablesFixedHeader = function () {

    var initTable1 = function () {
        var table = $('#sample_1');

        var fixedHeaderOffset = 0;
        if (App.getViewPort().width < App.getResponsiveBreakpoint('md')) {
            if ($('.page-header').hasClass('page-header-fixed-mobile')) {
                fixedHeaderOffset = $('.page-header').outerHeight(true);
            } 
        } else if ($('.page-header').hasClass('navbar-fixed-top')) {
            fixedHeaderOffset = $('.page-header').outerHeight(true);
        }

        var oTable = table.dataTable({
            fixedHeader: {
                header: true,
                headerOffset: fixedHeaderOffset
            },

            "order": [
                [0, 'asc']
            ],
            
            "lengthMenu": [
                [5, 10, 15, 20, -1],
                [5, 10, 15, 20, "All"] // จำนวนข้อมูลที่แสดงต่อหน้า สำหรับให้เลือก
            ],
            // set the initial value
            "pageLength": 10//จำนวนข้อมูลที่แสดงต่อหน้า
      });
    }

    var initTable2 = function () {
        var table = $('#sample_2');

        var fixedHeaderOffset = 0;
        if (App.getViewPort().width < App.getResponsiveBreakpoint('md')) {
            if ($('.page-header').hasClass('page-header-fixed-mobile')) {
                fixedHeaderOffset = $('.page-header').outerHeight(true);
            } 
        } else if ($('.page-header').hasClass('navbar-fixed-top')) {
            fixedHeaderOffset = $('.page-header').outerHeight(true);
        }

        var oTable = table.dataTable({
            // setup rowreorder extension: http://datatables.net/extensions/fixedheader/
            fixedHeader: {
                header: true,
                footer: true,
                headerOffset: fixedHeaderOffset
            },

            "order": [
                [0, 'asc']
            ],
            
            "lengthMenu": [
                [5, 10, 15, 30, -1],
                [5, 10, 15, 30, "All"] // จำนวนข้อมูลที่แสดงต่อหน้า สำหรับให้เลือก
            ],
            // set the initial value
            "pageLength": 10//จำนวนข้อมูลที่แสดงต่อหน้า
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
        }

    };

}();

jQuery(document).ready(function() {
    TableDatatablesFixedHeader.init();
});
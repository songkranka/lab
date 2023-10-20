(function ($) {
    "use strict";

    $.fn.autocomplete = function (options, callback) {
        // default parameters
        var settings = $.extend({
            url: $.contextPath + "/autocomplete", 
            columnsUrl: $.contextPath + "/autocomplete/getColumns",
            sqlUrl: $.contextPath + "/autocomplete/getSql",
            valueUrl: $.contextPath + "/autocomplete/getValue",
            onchange: null,
            placeholder: "¡´ Tab / ¡´ Enter",  
            width: "500px",
            maxRow: 10,
            
            value: null,
            valid: null,   
            filter: null,
            
            flag: null, 
            help: null,
            onblur: null
        }, options);
        
        // --------------- variable ------------- //
        var onblurMode = false;
        var isTableDisplaying = false;
         // textbox id
        var textboxId = "";
        textboxId = $(this).attr('id');
        // column all list
        var columnsAll = [];
        // column data list show on table 
        var columnsData = [];
        // column header list show on table
        var columnsHeader = [];
        if (settings.help != null) {
            $.each(getColumns(), function (i, v) {
                columnsHeader.push(v["columnsHeader"]);
                columnsData.push(v["columnsData"]);
            });
        }
        
        // save data record that select, temporarily
        var selectedItem = {};
        // initialize DOM elements
        var el = {
            ddDiv: $("<div>", { "class": "adropdown"}),    //theme
            ddTable: $("<table>", { style: "width:" + settings.width })
        };
        // --------------- end variable ------------- //
        
        // wrap textbox with the div for style
        this.wrap("<div class='acontainer'>");
        // set text attribute
        $(this).attr("autocomplete", "off");
        $(this).attr("placeholder", settings.placeholder);
        // append div after the textbox 
        this.after(el.ddDiv);
        // fill div with table
        el.ddDiv.append(el.ddTable);
        el.ddTable.attr("cellspacing", "0");
        // create table columns header
        var header = "<thead><tr>";
        for (var i in columnsHeader) header = header + "<th>" + columnsHeader[i] + "</th>";
        header = header + "</thead></tr>";
        el.ddTable.append(header);
        
        // do not allow special characters
        $(this).keypress(function (event) {  });
        
        // textbox blur event
        $(this).focusout(function () {
            if (isTableDisplaying == true) {
                hideDropDown();
            }
            else {
                if (settings.onblur == true) {
                    if ($.isFunction(settings.valid)) {
                        var returnValue = settings.valid.call(this);
                        if (returnValue===false) return false;
                        else if (returnValue===true) {
                            getData();
                            onblurMode = true;
                        }
                        else alert(" please ! return true or false on valid function ");
                    } else {
                        getData();
                        onblurMode = true;
                    }
                }
            }
        });

        // textbox keypress events (return key, up and down arrow)
        // UP: 38, DOWN: 40, ENTER: 13, TAB: 9, SHIFT: 16, CTRL: 17, ALT: 18
        $(this).keydown(function (e) { 

            var tbody = el.ddTable.find("tbody");
            var selected = tbody.find(".atcp-selected");
            var returnValue = null;

            if (e.keyCode == 13 || e.which == 9) { // enter || tab
                onblurMode = false;
                if (isTableDisplaying == true) { 
                    e.preventDefault();
                    select();
                }
                else if (isTableDisplaying == false) {
                    if ($.isFunction(settings.valid)) {
                        returnValue = settings.valid.call(this);
                        if (returnValue===false) return false;
                        else if (returnValue===true) getData();
                        else alert(" please ! return true or false on valid function ");
                    } else {
                        getData();
                    }
                }
                e.preventDefault();
                return false;  
            }
            else if (e.keyCode == 38) { // up
                el.ddTable.find(".atcp-selected").removeClass("atcp-selected");
                if (selected.prev().length == 0) {
                    tbody.find("tr:last").addClass("atcp-selected");
                } else {
                    selected.prev().addClass("atcp-selected");
                }
            }
            else if (e.keyCode == 40) { // down
                tbody.find(".atcp-selected").removeClass("atcp-selected");
                if (selected.next().length == 0) {
                    tbody.find("tr:first").addClass("atcp-selected");
                } else {
                    el.ddTable.find(".atcp-selected").removeClass("atcp-selected");
                    selected.next().addClass("atcp-selected");
                }
            }
            else if (e.keyCode == 16 || e.keyCode == 17 || e.keyCode == 18) { }
            else {
                if (isTableDisplaying == true) {
                    if ($.isFunction(settings.valid)) {
                        returnValue = settings.valid.call(this);
                        if (returnValue===false) return false;
                        else if (returnValue===true) getData();
                        else alert(" please ! return true or false on valid function ");
                    } else {
                        getData();
                    }
                }
            }
            
        });
        
        function getColumns(){
            var returnColumns = null;
            $.ajax({
                type: 'post',
                dataType: 'json',
                data: {data: settings.help, flag: settings.flag},
                url: settings.columnsUrl,
                async: false,
                success: function (data) {
                    returnColumns = data;
                },
                error: function () {
                    
                }
            });
            return returnColumns;
        }
        
        function getSql(){
            var returnSql = null;
            var item = [];
            item.push($('#'+textboxId).val());
            var tempValue = null;
            if ($.isFunction(settings.value)) {
                tempValue = settings.value.call(this);
                for (var i in settings.value.call(this)) {
                     item.push(tempValue[i]);
                }
            }
            
            $.ajax({
                type: 'post',
                dataType: 'json',
                data: {data: settings.help, flag: settings.flag, value: item},
                url: settings.sqlUrl,
                async: false,
                success: function (data) {
                    returnSql = " select * from ( " + data[0]["sql"] + " ) where rownum <= " + settings.maxRow + " ";
                },
                error: function () {
                    
                }
            });
            return returnSql;
        }
        
        function getValue(){
            var returnValue = null;
            var dataSend = {};
            var item = [];
            item.push($('#'+textboxId).val());
            var tempValue = null;
            if ($.isFunction(settings.value)) {
                tempValue = settings.value.call(this);
                for (var i in settings.value.call(this)) {
                     item.push(tempValue[i]);
                }
            }
            dataSend["flag"] = settings.flag;
            dataSend["data"] = settings.help;
            dataSend["value"] = item;
            $.ajax({
                type: 'post',
                dataType: 'json',
                data: dataSend,
                url: settings.valueUrl,
                async: false,
                success: function (data) {
                    returnValue = data;
                },
                error: function () {
                    
                }
            });
            return returnValue;
        }
        
        function getData(){
            $(this).addClass("loading");

            var item = {};
            
            if (settings.help != null) {
                item["sql"] = getSql();
                
                var returnValue = [];
                var tempValue = getValue();
                for (var i in tempValue) {
                    returnValue.push(tempValue[i]["value"]);
                }
                item["value"] = returnValue;
            }
            $('.bootbox, .modal-backdrop').remove();
            $.ajax({
                type: 'POST' || 'GET',
                dataType: 'json',
                data: item,
                url: settings.url,
                async: false,
                success: ajaxData,
                error: function (xhr, ajaxOptions, thrownError) {
                    //$(this).removeClass("loading");
                    console.log('getData Error: ' + xhr.status + ' - ' + thrownError);
                },
                complete: function() {
                    $(this).data('requestRunning', false);
                }
            });
        }

        // call on Ajax success
        function ajaxData(jsonData){
            console.log('json size '+jsonData.length);
            
            // don't have filter function at js which call autocomplete
            if (settings.filter == null || settings.filter == "" || (typeof settings.filter === "undefined")){
                jsonParser(jsonData);
            }
            // have filter function at js which call autocomplete
            else if ($.isFunction(settings.filter)) {
                var data = [];
                var filterRecord = 0;
                if (jsonData.length < settings.maxRow) filterRecord = jsonData.length;
                else filterRecord = settings.maxRow;
                for (var i = 0; i < filterRecord; i++) { 
                    data.push(jsonData[i]); 
                }
                data = settings.filter.call(this, data);
                console.log('json size after filter '+data.length);
                jsonParser(data);
            }
        }
        
        function jsonParser(jsonData) {
            try{
                //$(this).removeClass("loading");

                // remove all rows from the table
                el.ddTable.find("tbody").find("tr").remove();

                var row = null;
                if (jsonData != null && jsonData.length != 0) {
                
                    if (jsonData.length == 1 && onblurMode == true) {
                        var singleData = jsonData[0];
                        for (var i in singleData) {
                            selectedItem[i] = singleData[i];
                        }
                        onChange();
                    }
                    else {
                        if (onblurMode != true) {
                            for (var i in jsonData) {
                                // control rows of data
                                if (i >= settings.maxRow) continue;
                                if (i==0) columnsAll = [];
                                
                                // append column to row and order column
                                row = "";
                                for (var key1 in columnsData) {
                                    for (var key2 in jsonData[i]) {
                                        if(columnsData[key1]==key2){
                                            row = row + "<td>" + jsonData[i][key2] +"</td>";
                                            if (i==0) columnsAll.push(columnsData[key1]);
                                        }
                                    }
                                }
                                for (var key in jsonData[i]) {
                                    if ($.inArray(key, columnsData) == -1){
                                        row = row + "<td>" + jsonData[i][key] +"</td>";
                                        if (i==0) columnsAll.push(key);
                                    }
                                }
               
                                // append row to the table
                                el.ddTable.append("<tr>" + row + "</tr>");
                            }// end for row
                            
                            // hide dropdown column every row
                            for (var i in columnsAll) {  
                                // compare same value
                                if ($.inArray(columnsAll[i], columnsData) == -1){
                                    el.ddTable.find('td:nth-child('+(parseInt(i)+1)+')').hide();
                                }
                            }
            
                            el.ddTable.find("tbody").find("tr:first").addClass('atcp-selected');
                            showDropDown();
                        }
                        
                    }
                }
                // when no data
                else{
                    selectedItem = {};
                    hideDropDown();
                    onChange();
                }   
            } // end try
            catch(e){
                console.log("jsonParser Error: " + e);
            }
        }

        // row click event
        el.ddTable.delegate("tr", "mousedown", function () {
            el.ddTable.find(".atcp-selected").removeClass("atcp-selected");
            $(this).addClass("atcp-selected");
            select();
        });

        function select() {
            var selected = el.ddTable.find("tbody").find(".atcp-selected").find('td');
            $(this).val(selected.eq(0).text());
            // clear data every time that select
            selectedItem = {}; 
            for (var i in columnsAll) selectedItem[columnsAll[i]] = selected.eq(i).text(); 
            hideDropDown();
        
            // check no data or clik column header, not onchange
            if(columnsAll.length > 0 && selected.length > 0) onChange();
            
            $(this).focus();
        }

        function onChange(){
            if ($.isFunction(settings.onchange)) settings.onchange.call(this);
        }

        function hideDropDown() {
            el.ddTable.hide();
            $('#'+textboxId).removeClass("inputfocus");
            el.ddDiv.removeClass("highlight");
            
            $(".adropdown table tbody").each(function(){
                $(this).remove();
            });
            
            isTableDisplaying = false;
        }

        function showDropDown() {
            var cssTop = ($('#'+textboxId).height() + 20) + "px 1px 0px 1px";
            var cssBottom = "1px 1px " + ($('#'+textboxId).height() + 20) + "px 1px";
            // reset div top, left and margin
            el.ddDiv.css("top", "0px");
            el.ddDiv.css("left", "0px");
            el.ddTable.css("margin", cssTop);
            $('#'+textboxId).addClass("inputfocus");
            el.ddDiv.addClass("highlight");
            el.ddTable.show();
            
            // adjust div top according to the visibility
            if (!isDivHeightVisible(el.ddDiv)) {
                el.ddDiv.css("top", -1 * (el.ddTable.height()) + "px");
                el.ddTable.css("margin", cssBottom);
                if (!isDivHeightVisible(el.ddDiv)) {
                    el.ddDiv.css("top", "0px");
                    el.ddTable.css("margin", cssTop);
                    $('html, body').animate({ scrollTop: (el.ddDiv.offset().top - 60)}, 250);
                }
            }
            
            // adjust div left according to the visibility
            if (!isDivWidthVisible(el.ddDiv)) {
                el.ddDiv.css("left", "-" + (el.ddTable.width() - $(this).width() - 20) + "px");
            }
            
            isTableDisplaying = true;
        } 
        
        // return value 
        var autocomplete = function (key) { 
            if (typeof key === "undefined") {
                var length = 0;
                $.each(selectedItem, function (i, v) { length++; });
                return length; 
            }
            else return selectedItem[key];   
        }
        return autocomplete;
    };
}(jQuery));

function isDivHeightVisible(elem) {
    var docViewTop = $(window).scrollTop();
    var docViewBottom = docViewTop + $(window).height();

    var elemTop = $(elem).offset().top;
    var elemBottom = elemTop + $(elem).height();
    
    console.log("docViewTop "+docViewTop+", docViewBottom"+docViewBottom+", elemTop"+elemTop+", elemBottom"+elemBottom);

    return ((elemBottom >= docViewTop) && (elemTop <= docViewBottom)
      && (elemBottom <= docViewBottom) && (elemTop >= docViewTop));
}
function isDivWidthVisible(elem) {
    var docViewLeft = $(window).scrollLeft();
    var docViewRight = docViewLeft + $(window).width();

    var elemLeft = $(elem).offset().left;
    var elemRight = elemLeft + $(elem).width();
    
    console.log("docViewLeft "+docViewLeft+", docViewRight"+docViewRight+", elemLeft"+elemLeft+", elemRight"+elemRight);

    return ((elemRight >= docViewLeft) && (elemLeft <= docViewRight)
      && (elemRight <= docViewRight) && (elemLeft >= docViewLeft));
}
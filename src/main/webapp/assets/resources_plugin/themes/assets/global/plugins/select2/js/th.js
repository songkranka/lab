/*! Select2 4.0.0 | https://github.com/select2/select2/blob/master/LICENSE.md */

(function(){if(jQuery&&jQuery.fn&&jQuery.fn.select2&&jQuery.fn.select2.amd)var e=jQuery.fn.select2.amd;return e.define("select2/th",[],function(){return{inputTooLong:function(e){var t=e.input.length-e.maximum,n="�ôź�͡ "+t+" ����ѡ��";return n},inputTooShort:function(e){var t=e.minimum-e.input.length,n="�ô����������ա "+t+" ����ѡ��";return n},loadingMore:function(){return"���ѧ�鹢���������?"},maximumSelected:function(e){var t="�س����ö���͡������Թ "+e.maximum+" ��¡��";return t},noResults:function(){return"��辺������"},searching:function(){return"���ѧ�鹢�����?"}}}),{define:e.define,require:e.require}})();
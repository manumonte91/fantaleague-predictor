var Mask = Mask || (function($) {

    /*var _defaults = {
        ctx: '/Cedacri'
    };
    var _settings;*/
    var _locked;

    function _init() {
        var ctx = $("#ctxRoot").val();
        //_settings = $.extend({}, _defaults, options);
        
        var maschera = $("#maschera");
        if(maschera.length > 0) {
            maschera.css({
                backgroundColor: 'rgba(255, 255, 255, 0.5)'
                //background: 'transparent url("../assets/maschera.png") repeat top left'
            });
            var loader = $('<div><span><img src="'+ctx+'/assets/loading.gif" /></span></div>');
            
            loader.appendTo(maschera);
        }
        
        _locked = false;
    };

    function _lock(id, showLoader) {
        if(showLoader === undefined || showLoader === null) {
            showLoader = true;
        } else {
            showLoader = false;
        }
        var _id = id || "#wrapper";
        var element = $(_id);
        var maschera = $("#maschera");
        if(element.length > 0 && maschera.length > 0) {
            var loader = $("#maschera div");
            var offset = element.offset();
            maschera.css({
                width: element.width(),
                height: element.height(),
                top: offset.top,
                left: offset.left
            });
            var displayLoader = 'block';
            if(!showLoader) {
                displayLoader = 'none';
            }
            loader.css({
                top: (maschera.height() / 2) - loader.innerHeight() / 2,
                left: (maschera.width() / 2) - loader.innerWidth() / 2,
                display: displayLoader
            });
            maschera.show();
            _locked = true;
        }
    };
    
    function _unlock() {
        var maschera = $("#maschera");
        if(maschera.length > 0) {
            maschera.hide();
            maschera.css({'cursor': 'default'});
            maschera.off('click');
            _locked = false;
        }
    };
    
    function _addOneShotClickHandler(fn) {
        var maschera = $("#maschera");
        if(maschera.length > 0) {
            maschera.css({'cursor': 'pointer'});
            maschera.one('click', fn);
        }
    }

    return {
        init: function(options) {
            _init(options);
        },
        lock: function(id, showLoader) {
            _lock(id, showLoader);
        },
        unlock: function() {
            _unlock();
        },
        addOneShotClickHandler: function(fn) {
            _addOneShotClickHandler(fn);
        }
    };

})(jQuery);
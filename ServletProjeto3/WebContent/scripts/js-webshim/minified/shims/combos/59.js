jQuery.webshims.register("form-extend",function(b,c,d,k,p,l){var e=d.Modernizr,d=e.inputtypes;if(e.formvalidation){var n=c.inputTypes,q={};c.addInputType=function(b,a){n[b]=a};c.addValidityRule=function(b,a){q[b]=a};c.addValidityRule("typeMismatch",function(b,a,g,c){if(""===a)return!1;c=c.typeMismatch;if(!("type"in g))g.type=(b[0].getAttribute("type")||"").toLowerCase();n[g.type]&&n[g.type].mismatch&&(c=n[g.type].mismatch(a,b));return c});var m=l.overrideMessages,r=!e.requiredSelect||!d.number||!d.time||
!d.range||m,a="customError,typeMismatch,rangeUnderflow,rangeOverflow,stepMismatch,tooLong,patternMismatch,valueMissing,valid".split(","),l=m?["value","checked"]:["value"],h=m?["textarea"]:[],f=function(a,g){if(a){var c=(a.getAttribute&&a.getAttribute("type")||a.type||"").toLowerCase();if(m||!(e.requiredSelect||"select-one"!=c)||n[c])m&&!g&&"radio"==c&&a.name?b(k.getElementsByName(a.name)).each(function(){b.prop(this,"validity")}):b.prop(a,"validity")}},j={};["input","textarea","select"].forEach(function(a){var g=
c.defineNodeNameProperty(a,"setCustomValidity",{prop:{value:function(i){var i=i+"",h="input"==a?b(this).getNativeElement()[0]:this;g.prop._supvalue.call(h,i);c.bugs.validationMessage&&c.data(h,"customvalidationMessage",i);r&&(c.data(h,"hasCustomError",!!i),f(h))}}});j[a]=g.prop._supvalue});if(r||!e.input.valueAsNumber||m)l.push("min"),l.push("max"),l.push("step"),h.push("input");if(!e.requiredSelect||m)l.push("required"),h.push("select");if(r){var g;h.forEach(function(i){var h=c.defineNodeNameProperty(i,
"validity",{prop:{get:function(){if(!g){var f="input"==i?b(this).getNativeElement()[0]:this,o=h.prop._supget.call(f);if(!o)return o;var d={};a.forEach(function(b){d[b]=o[b]});if(!b.prop(f,"willValidate"))return d;g=!0;var e=b(f),k={type:(f.getAttribute&&f.getAttribute("type")||"").toLowerCase(),nodeName:(f.nodeName||"").toLowerCase()},r=e.val(),l=!!c.data(f,"hasCustomError"),n;g=!1;d.customError=l;if(d.valid&&d.customError)d.valid=!1;else if(!d.valid){var p=!0;b.each(d,function(b,a){if(a)return p=
!1});if(p)d.valid=!0}b.each(q,function(b,a){d[b]=a(e,r,k,d);if(d[b]&&(d.valid||!n))j[i].call(f,c.createValidationMessage(f,b)),d.valid=!1,n=!0});d.valid?(j[i].call(f,""),c.data(f,"hasCustomError",!1)):m&&!n&&!l&&b.each(d,function(b,a){if("valid"!==b&&a)return j[i].call(f,c.createValidationMessage(f,b)),!1});return d}},writeable:!1}})});l.forEach(function(b){c.onNodeNamesPropertyModify(h,b,function(){f(this)})});if(k.addEventListener){var o;k.addEventListener("change",function(b){clearTimeout(o);f(b.target)},
!0);k.addEventListener("input",function(b){clearTimeout(o);o=setTimeout(function(){f(b.target)},290)},!0)}var i=h.join(",");c.addReady(function(a,g){b(i,a).add(g.filter(i)).each(function(){b.prop(this,"validity")})});m&&c.ready("DOM form-message",function(){c.activeLang({register:"form-core",callback:function(){b("input, select, textarea").getNativeElement().each(function(){if(!c.data(this,"hasCustomError")){var a=this,g=b.prop(a,"validity")||{valid:!0},i;g.valid||(i=(a.nodeName||"").toLowerCase(),
b.each(g,function(b,g){if("valid"!==b&&g)return j[i].call(a,c.createValidationMessage(a,b)),!1}))}})}})})}c.defineNodeNameProperty("input","type",{prop:{get:function(){var b=(this.getAttribute("type")||"").toLowerCase();return c.inputTypes[b]?b:this.type}}});e.input.list&&!(b("<datalist><select><option></option></select></datalist>").prop("options")||[]).length&&c.defineNodeNameProperty("datalist","options",{prop:{writeable:!1,get:function(){var a=this.options||[];if(!a.length){var g=b("select",this);
if(g[0]&&g[0].options&&g[0].options.length)a=g[0].options}return a}}})}});jQuery.webshims.gcEval=function(b,c){with(c&&c.form||window)with(c||window)return function(b){eval(b)}.call(c||window,b)};
(function(b){var c=window.Modernizr,d=b.webshims;d.capturingEventPrevented=function(c){var d=c.isDefaultPrevented,e=c.preventDefault;c.preventDefault=function(){clearTimeout(b.data(c.target,c.type+"DefaultPrevented"));b.data(c.target,c.type+"DefaultPrevented",setTimeout(function(){b.removeData(c.target,c.type+"DefaultPrevented")},30));return e.apply(this,arguments)};c.isDefaultPrevented=function(){return!(!d.apply(this,arguments)&&!b.data(c.target,c.type+"DefaultPrevented"))};c._isPolyfilled=!0};
if(c.formvalidation){var k=b('<form action="#" style="width: 1px; height: 1px; overflow: hidden;"><select /><input type="date" required name="a" /><input type="submit" /></form>');c.bugfreeformvalidation=c.requiredSelect=!!("required"in b("select",k)[0]);if(window.opera||b.browser.webkit||window.testGoodWithFix){var p=b("input",k),l,e=function(e){var m=["form-extend","form-native-fix"];e&&(e.preventDefault(),e.stopImmediatePropagation());clearTimeout(l);setTimeout(function(){k&&(k.remove(),k=p=null)},
9);if(!c.bugfreeformvalidation||!c.requiredSelect)d.addPolyfill("form-native-fix",{f:"forms",d:["form-extend"]}),d.modules["form-extend"].test=b.noop;d.isReady("form-number-date-api")&&m.push("form-number-date-api");d.bugs.validationMessage&&m.push("form-message");d.reTest(m);if(b.browser.opera||window.testGoodWithFix)d.loader.loadList(["dom-extend"]),d.ready("dom-extend",function(){var c=function(b){b.preventDefault()};["form","input","textarea","select"].forEach(function(a){var h=d.defineNodeNameProperty(a,
"checkValidity",{prop:{value:function(){d.fromSubmit||b(this).bind("invalid.checkvalidity",c);d.fromCheckValidity=!0;var a=h.prop._supvalue.apply(this,arguments);d.fromSubmit||b(this).unbind("invalid.checkvalidity",c);d.fromCheckValidity=!1;return a}}})})}),c.input.list&&!(b("<datalist><select><option></option></select></datalist>").prop("options")||[]).length&&d.defineNodeNameProperty("datalist","options",{prop:{writeable:!1,get:function(){var c=this.options||[];if(!c.length){var a=b("select",this);
if(a[0]&&a[0].options&&a[0].options.length)c=a[0].options}return c}}})};k.appendTo("head");if(window.opera||window.testGoodWithFix){d.bugs.validationMessage=!p.prop("validationMessage");if((c.inputtypes||{}).date){try{p.prop("valueAsNumber",0)}catch(n){}d.bugs.valueAsNumberSet="1970-01-01"!=p.prop("value")}p.prop("value","")}k.bind("submit",function(b){c.bugfreeformvalidation=!1;e(b)});l=setTimeout(function(){k&&k.triggerHandler("submit")},9);d.capturingEvents(["input"]);d.capturingEvents(["invalid"],
!0);b("input, select",k).bind("invalid",e).filter('[type="submit"]').bind("click",function(b){b.stopImmediatePropagation()}).trigger("click")}else d.capturingEvents(["input"]),d.capturingEvents(["invalid"],!0)}})(jQuery);
jQuery.webshims.register("form-core",function(b,c,d,k,p,l){var e={radio:1},n={checkbox:1,radio:1},q=b([]),m=function(a){var a=b(a),c=a[0].name;return e[a[0].type]&&c?b(a[0].form&&a[0].form[c]||k.getElementsByName(c)).not(a[0]):q},r=c.getContentValidationMessage=function(a,f){var i=a.getAttribute("x-moz-errormessage")||a.getAttribute("data-errormessage")||"";if(i&&-1!=i.indexOf("{")){try{i=jQuery.parseJSON(i)}catch(h){return i}"object"==typeof i&&(f=f||b.prop(a,"validity")||{valid:1},f.valid||b.each(f,
function(b,a){if(a&&"valid"!=b&&i[b])return i=i[b],!1}));c.data(a,"contentErrorMessage",i);if("object"==typeof i)i=i.defaultMessage}return i||""},a={number:1,range:1,date:1,time:1,"datetime-local":1,datetime:1,month:1,week:1};b.extend(b.expr.filters,{"valid-element":function(a){return!(!b.prop(a,"willValidate")||!(b.prop(a,"validity")||{valid:1}).valid)},"invalid-element":function(a){return!(!b.prop(a,"willValidate")||(b.prop(a,"validity")||{valid:1}).valid)},"required-element":function(a){return!(!b.prop(a,
"willValidate")||!b.prop(a,"required"))},"optional-element":function(a){return!!(b.prop(a,"willValidate")&&!1===b.prop(a,"required"))},"in-range":function(g){if(!a[b.prop(g,"type")]||!b.prop(g,"willValidate"))return!1;g=b.prop(g,"validity");return!(!g||g.rangeOverflow||g.rangeUnderflow)},"out-of-range":function(g){if(!a[b.prop(g,"type")]||!b.prop(g,"willValidate"))return!1;g=b.prop(g,"validity");return!(!g||!g.rangeOverflow&&!g.rangeUnderflow)}});["valid","invalid","required","optional"].forEach(function(a){b.expr.filters[a]=
b.expr.filters[a+"-element"]});var d=b.event.customEvent||{},h=b.prop,f={selectedIndex:1,value:1,checked:1,disabled:1,readonly:1};b.prop=function(a,c,i){var d=h.apply(this,arguments);if(a&&"form"in a&&f[c]&&i!==p&&b(a).hasClass("form-ui-invalid")&&(b.prop(a,"validity")||{valid:1}).valid)b(a).getShadowElement().removeClass("form-ui-invalid"),"checked"==c&&i&&m(a).removeClass("form-ui-invalid").removeAttr("aria-invalid");return d};var j=function(a,c){var i;b.each(a,function(a,g){if(g)return i="customError"==
a?b.prop(c,"validationMessage"):a,!1});return i};b(k).bind("focusout change refreshvalidityui",function(a){if(a.target&&"submit"!=a.target.type&&b.prop(a.target,"willValidate")){var c=b.data(a.target,"webshimsswitchvalidityclass");c&&clearTimeout(c);b.data(a.target,"webshimsswitchvalidityclass",setTimeout(function(){var c=b(a.target).getNativeElement()[0],f=b.prop(c,"validity"),h=b(c).getShadowElement(),d,e,o,k;f.valid?h.hasClass("form-ui-valid")||(d="form-ui-valid",e="form-ui-invalid",k="changedvaliditystate",
o="changedvalid",n[c.type]&&c.checked&&m(c).removeClass(e).addClass(d).removeAttr("aria-invalid"),b.removeData(c,"webshimsinvalidcause")):(f=j(f,c),b.data(c,"webshimsinvalidcause")!=f&&(b.data(c,"webshimsinvalidcause",f),k="changedvaliditystate"),h.hasClass("form-ui-invalid")||(d="form-ui-invalid",e="form-ui-valid",n[c.type]&&!c.checked&&m(c).removeClass(e).addClass(d),o="changedinvalid"));d&&(h.addClass(d).removeClass(e),setTimeout(function(){b(c).trigger(o)},0));k&&setTimeout(function(){b(c).trigger(k)},
0);b.removeData(a.target,"webshimsswitchvalidityclass")},9))}});d.changedvaliditystate=!0;d.changedvalid=!0;d.changedinvalid=!0;d.refreshvalidityui=!0;c.triggerInlineForm=function(a,f){a.jquery&&(a=a[0]);var h="on"+f,d=a[h]||a.getAttribute(h)||"",j,e,f=b.Event({type:f,target:a,currentTarget:a});d&&(c.warn(h+" used. we will drop inline event handler support, with next release. use event binding: $.bind instead"),"string"==typeof d&&(e=c.gcEval(d,a),a[h]&&(j=!0,a[h]=!1)));!1===e&&(f.stopPropagation(),
f.preventDefault());b(a).trigger(f);j&&(a[h]=d);return e};d=function(){c.scrollRoot=b.browser.webkit||"BackCompat"==k.compatMode?b(k.body):b(k.documentElement)};d();c.ready("DOM",d);c.validityAlert=function(){var a=!b.browser.msie||7<parseInt(b.browser.version,10)?"span":"label",f={top:0,left:0},h={hideDelay:5E3,getBodyOffset:function(){f=d.offset()},showFor:function(a,c,g,f){h._create();var a=b(a),e=b(a).getShadowElement(),o=h.getOffsetFromBody(e);h.clear();f?this.hide():(this.getMessage(a,c),this.position(e,
o),d.css({fontSize:a.css("fontSize"),fontFamily:a.css("fontFamily")}),this.show(),this.hideDelay&&(j=setTimeout(q,this.hideDelay)));g||this.setFocus(e,o)},getOffsetFromBody:function(a){a=b(a).offset();b.swap(d[0],{visibility:"hidden",display:"inline-block",left:0,top:0},h.getBodyOffset);a.top-=f.top;a.left-=f.left;return a},setFocus:function(f,h){var j=b(f).getShadowFocusElement(),e=c.scrollRoot.scrollTop(),i=(h||j.offset()).top-30,o;c.getID&&"label"==a&&d.attr("for",c.getID(j));e>i&&(c.scrollRoot.animate({scrollTop:i-
5},{queue:!1,duration:Math.max(Math.min(600,1.5*(e-i)),80)}),o=!0);try{j[0].focus()}catch(l){}o&&(c.scrollRoot.scrollTop(e),setTimeout(function(){c.scrollRoot.scrollTop(e)},0));setTimeout(function(){b(k).bind("focusout.validityalert",q)},10)},getMessage:function(a,c){b("span.va-box",d).text(c||r(a[0])||a.prop("validationMessage"))},position:function(a,c){c=c?b.extend({},c):h.getOffsetFromBody(a);c.top+=a.outerHeight();d.css(c)},show:function(){"none"===d.css("display")&&d.css({opacity:0}).show();
d.addClass("va-visible").fadeTo(400,1)},hide:function(){d.removeClass("va-visible").fadeOut()},clear:function(){clearTimeout(e);clearTimeout(j);b(k).unbind("focusout.validityalert");d.stop().removeAttr("for")},_create:function(){if(!d)d=h.errorBubble=b("<"+a+' class="validity-alert-wrapper" role="alert"><span  class="validity-alert"><span class="va-arrow"><span class="va-arrow-box"></span></span><span class="va-box"></span></span></'+a+">").css({position:"absolute",display:"none"}),c.ready("DOM",
function(){d.appendTo("body");b.fn.bgIframe&&b.browser.msie&&7>parseInt(b.browser.version,10)&&d.bgIframe()})}},d,j=!1,e=!1,q=b.proxy(h,"hide");return h}();(function(){var a,c=[],f;b(k).bind("invalid",function(h){if(!h.wrongWebkitInvalid){var d=b(h.target),j=d.getShadowElement();j.hasClass("form-ui-invalid")||(j.addClass("form-ui-invalid").removeClass("form-ui-valid"),setTimeout(function(){b(h.target).trigger("changedinvalid").trigger("changedvaliditystate")},0));if(!a)a=b.Event("firstinvalid"),a.isInvalidUIPrevented=
h.isDefaultPrevented,j=b.Event("firstinvalidsystem"),b(k).triggerHandler(j,{element:h.target,form:h.target.form,isInvalidUIPrevented:h.isDefaultPrevented}),d.trigger(a);a&&a.isDefaultPrevented()&&h.preventDefault();c.push(h.target);h.extraData="fix";clearTimeout(f);f=setTimeout(function(){var f={type:"lastinvalid",cancelable:!1,invalidlist:b(c)};a=!1;c=[];b(h.target).trigger(f,f)},9);j=d=null}})})();l.replaceValidationUI&&c.ready("DOM",function(){b(k).bind("firstinvalid",function(a){a.isInvalidUIPrevented()||
(a.preventDefault(),b.webshims.validityAlert.showFor(a.target,b(a.target).prop("customValidationMessage")))})})});
jQuery.webshims.register("form-message",function(b,c,d,k,p,l){var e=c.validityMessages,d=l.overrideMessages||l.customMessages?["customValidationMessage"]:[];e.en=e.en||e["en-US"]||{typeMismatch:{email:"Please enter an email address.",url:"Please enter a URL.",number:"Please enter a number.",date:"Please enter a date.",time:"Please enter a time.",range:"Invalid input.","datetime-local":"Please enter a datetime."},rangeUnderflow:{defaultMessage:"Value must be greater than or equal to {%min}."},rangeOverflow:{defaultMessage:"Value must be less than or equal to {%max}."},
stepMismatch:"Invalid input.",tooLong:"Please enter at most {%maxlength} character(s). You entered {%valueLen}.",patternMismatch:"Invalid input. {%title}",valueMissing:{defaultMessage:"Please fill out this field.",checkbox:"Please check this box if you want to proceed."}};["select","radio"].forEach(function(b){e.en.valueMissing[b]="Please select an option."});["date","time","datetime-local"].forEach(function(b){e.en.rangeUnderflow[b]="Value must be at or after {%min}."});["date","time","datetime-local"].forEach(function(b){e.en.rangeOverflow[b]=
"Value must be at or before {%max}."});e["en-US"]=e["en-US"]||e.en;e[""]=e[""]||e["en-US"];e.de=e.de||{typeMismatch:{email:"{%value} ist keine zul\u00e4ssige E-Mail-Adresse",url:"{%value} ist keine zul\u00e4ssige Webadresse",number:"{%value} ist keine Nummer!",date:"{%value} ist kein Datum",time:"{%value} ist keine Uhrzeit",range:"{%value} ist keine Nummer!","datetime-local":"{%value} ist kein Datum-Uhrzeit Format."},rangeUnderflow:{defaultMessage:"{%value} ist zu niedrig. {%min} ist der unterste Wert, den Sie benutzen k\u00f6nnen."},
rangeOverflow:{defaultMessage:"{%value} ist zu hoch. {%max} ist der oberste Wert, den Sie benutzen k\u00f6nnen."},stepMismatch:"Der Wert {%value} ist in diesem Feld nicht zul\u00e4ssig. Hier sind nur bestimmte Werte zul\u00e4ssig. {%title}",tooLong:"Der eingegebene Text ist zu lang! Sie haben {%valueLen} Zeichen eingegeben, dabei sind {%maxlength} das Maximum.",patternMismatch:"{%value} hat f\u00fcr dieses Eingabefeld ein falsches Format! {%title}",valueMissing:{defaultMessage:"Bitte geben Sie einen Wert ein",
checkbox:"Bitte aktivieren Sie das K\u00e4stchen"}};["select","radio"].forEach(function(b){e.de.valueMissing[b]="Bitte w\u00e4hlen Sie eine Option aus"});["date","time","datetime-local"].forEach(function(b){e.de.rangeUnderflow[b]="{%value} ist zu fr\u00fch. {%min} ist die fr\u00fcheste Zeit, die Sie benutzen k\u00f6nnen."});["date","time","datetime-local"].forEach(function(b){e.de.rangeOverflow[b]="{%value} ist zu sp\u00e4t. {%max} ist die sp\u00e4teste Zeit, die Sie benutzen k\u00f6nnen."});var n=
e[""];c.createValidationMessage=function(c,d){var e=n[d];e&&"string"!==typeof e&&(e=e[b.prop(c,"type")]||e[(c.nodeName||"").toLowerCase()]||e.defaultMessage);e&&"value,min,max,title,maxlength,label".split(",").forEach(function(a){if(-1!==e.indexOf("{%"+a)){var h=("label"==a?b.trim(b('label[for="'+c.id+'"]',c.form).text()).replace(/\*$|:$/,""):b.attr(c,a))||"";e=e.replace("{%"+a+"}",h);"value"==a&&(e=e.replace("{%valueLen}",h.length))}});return e||""};(c.bugs.validationMessage||!Modernizr.formvalidation)&&
d.push("validationMessage");c.activeLang({langObj:e,module:"form-core",callback:function(b){n=b}});Modernizr.input.list&&!(b("<datalist><select><option></option></select></datalist>").prop("options")||[]).length&&c.defineNodeNameProperty("datalist","options",{prop:{writeable:!1,get:function(){var c=this.options||[];if(!c.length){var d=b("select",this);if(d[0]&&d[0].options&&d[0].options.length)c=d[0].options}return c}}});d.forEach(function(d){c.defineNodeNamesProperty(["fieldset","output","button"],
d,{prop:{value:"",writeable:!1}});["input","select","textarea"].forEach(function(e){var k=c.defineNodeNameProperty(e,d,{prop:{get:function(){var a=this,h="";if(!b.prop(a,"willValidate"))return h;var f=b.prop(a,"validity")||{valid:1};if(f.valid||(h=c.getContentValidationMessage(a,f)))return h;if(f.customError&&a.nodeName&&(h=Modernizr.formvalidation&&k.prop._supget?k.prop._supget.call(a):c.data(a,"customvalidationMessage")))return h;b.each(f,function(b,f){if("valid"!=b&&f&&(h=c.createValidationMessage(a,
b)))return!1});return h||""},writeable:!1}})})})});
jQuery.webshims.register("form-datalist",function(b,c,d,k,p){c.propTypes.element=function(d){c.createPropDefault(d,"attr");if(!d.prop)d.prop={get:function(){var c=d.attr.get.call(this);c&&(c=b("#"+c)[0])&&d.propNodeName&&!b.nodeName(c,d.propNodeName)&&(c=null);return c||null},writeable:!1}};(function(){if(!Modernizr.input.list){var l=0,e={submit:1,button:1,reset:1,hidden:1,range:1,date:1},n=b.browser.msie&&7>parseInt(b.browser.version,10),q={},m=function(a){if(!a)return[];if(q[a])return q[a];var b;
try{b=JSON.parse(localStorage.getItem("storedDatalistOptions"+a))}catch(c){}q[a]=b||[];return b||[]},r={_create:function(a){if(!e[b.prop(a.input,"type")]){var c=a.datalist,f=b.data(a.input,"datalistWidget");if(c&&f&&f.datalist!==c)f.datalist=c,f.id=a.id,f._resetListCached();else if(c){if(!(f&&f.datalist===c)){l++;var j=this;this.hideList=b.proxy(j,"hideList");this.timedHide=function(){clearTimeout(j.hideTimer);j.hideTimer=setTimeout(j.hideList,9)};this.datalist=c;this.id=a.id;this.hasViewableData=
!0;this._autocomplete=b.attr(a.input,"autocomplete");b.data(a.input,"datalistWidget",this);this.shadowList=b('<div class="datalist-polyfill" />').appendTo("body");this.index=-1;this.input=a.input;this.arrayOptions=[];this.shadowList.delegate("li","mouseenter.datalistWidget mousedown.datalistWidget click.datalistWidget",function(a){var c=b("li:not(.hidden-item)",j.shadowList),d="mousedown"==a.type||"click"==a.type;j.markItem(c.index(a.currentTarget),d,c);"click"==a.type&&j.hideList();return"mousedown"!=
a.type}).bind("focusout",this.timedHide);a.input.setAttribute("autocomplete","off");b(a.input).attr({"aria-haspopup":"true"}).bind("input.datalistWidget",function(){if(!j.triggeredByDatalist)j.changedValue=!1,j.showHideOptions()}).bind("keydown.datalistWidget",function(a){var c=a.keyCode;if(40==c&&!j.showList())return j.markItem(j.index+1,!0),!1;if(j.isListVisible){if(38==c)return j.markItem(j.index-1,!0),!1;if(!a.shiftKey&&(33==c||36==c))return j.markItem(0,!0),!1;if(!a.shiftKey&&(34==c||35==c))return a=
b("li:not(.hidden-item)",j.shadowList),j.markItem(a.length-1,!0,a),!1;if(13==c||27==c)return 13==c&&j.changeValue(b("li.active-item:not(.hidden-item)",j.shadowList)),j.hideList(),!1}}).bind("focus.datalistWidget",function(){b(this).hasClass("list-focus")&&j.showList()}).bind("blur.datalistWidget",this.timedHide);b(this.datalist).unbind("updateDatalist.datalistWidget").bind("updateDatalist.datalistWidget",b.proxy(this,"_resetListCached"));this._resetListCached();a.input.form&&a.input.id&&b(a.input.form).bind("submit.datalistWidget"+
a.input.id,function(){var c=b.prop(a.input,"value"),d=(a.input.name||a.input.id)+b.prop(a.input,"type");if(!j.storedOptions)j.storedOptions=m(d);if(c&&-1==j.storedOptions.indexOf(c)&&(j.storedOptions.push(c),c=j.storedOptions,d)){c=c||[];try{localStorage.setItem("storedDatalistOptions"+d,JSON.stringify(c))}catch(f){}}});b(d).bind("unload",function(){j.destroy()})}}else f&&f.destroy()}},destroy:function(){var a=b.attr(this.input,"autocomplete");b(this.input).unbind(".datalistWidget").removeData("datalistWidget");
this.shadowList.remove();b(k).unbind(".datalist"+this.id);this.input.form&&this.input.id&&b(this.input.form).unbind("submit.datalistWidget"+this.input.id);this.input.removeAttribute("aria-haspopup");a===p?this.input.removeAttribute("autocomplete"):b(this.input).attr("autocomplete",a)},_resetListCached:function(a){var b=this,f;this.needsUpdate=!0;this.lastUpdatedValue=!1;this.lastUnfoundValue="";this.updateTimer||(d.QUnit||(f=a&&k.activeElement==b.input)?b.updateListOptions(f):c.ready("WINDOWLOAD",
function(){b.updateTimer=setTimeout(function(){b.updateListOptions();b=null;l=1},200+100*l)}))},updateListOptions:function(a){this.needsUpdate=!1;clearTimeout(this.updateTimer);this.updateTimer=!1;this.shadowList.css({fontSize:b.curCSS(this.input,"fontSize"),fontFamily:b.curCSS(this.input,"fontFamily")});var c=[],d=[],e=[],g,k,i,l;for(k=b.prop(this.datalist,"options"),i=0,l=k.length;i<l;i++){g=k[i];if(g.disabled)return;g={value:b(g).val()||"",text:b.trim(b.attr(g,"label")||g.textContent||g.innerText||
b.text([g])||""),className:g.className||"",style:b.attr(g,"style")||""};g.text?g.text!=g.value&&(g.className+=" different-label-value"):g.text=g.value;d[i]=g.value;e[i]=g}if(!this.storedOptions)this.storedOptions=m((this.input.name||this.input.id)+b.prop(this.input,"type"));this.storedOptions.forEach(function(a){-1==d.indexOf(a)&&e.push({value:a,text:a,className:"stored-suggest",style:""})});for(i=0,l=e.length;i<l;i++)k=e[i],c[i]='<li class="'+k.className+'" style="'+k.style+'" tabindex="-1" role="listitem"><span class="option-label">'+
k.text+'</span> <span class="option-value">'+k.value+"</span></li>";this.arrayOptions=e;this.shadowList.html('<ul role="list" class="'+(this.datalist.className||"")+" "+this.datalist.id+'-shadowdom">'+c.join("\n")+"</ul>");b.fn.bgIframe&&n&&this.shadowList.bgIframe();(a||this.isListVisible)&&this.showHideOptions()},showHideOptions:function(){var a=b.prop(this.input,"value").toLowerCase();if(!(a===this.lastUpdatedValue||this.lastUnfoundValue&&0===a.indexOf(this.lastUnfoundValue))){this.lastUpdatedValue=
a;var c=!1,d=b("li",this.shadowList);a?this.arrayOptions.forEach(function(e,g){if(!("lowerText"in e))e.lowerText=e.text!=e.value?e.text.toLowerCase()+e.value.toLowerCase():e.text.toLowerCase();-1!==e.lowerText.indexOf(a)?(b(d[g]).removeClass("hidden-item"),c=!0):b(d[g]).addClass("hidden-item")}):d.length&&(d.removeClass("hidden-item"),c=!0);(this.hasViewableData=c)?this.showList():(this.lastUnfoundValue=a,this.hideList())}},getPos:function(){var a=b(this.input).offset();a.top+=b(this.input).outerHeight();
a.width=b(this.input).outerWidth()-(parseInt(this.shadowList.css("borderLeftWidth"),10)||0)-(parseInt(this.shadowList.css("borderRightWidth"),10)||0);return a},showList:function(){if(this.isListVisible)return!1;this.needsUpdate&&this.updateListOptions();this.showHideOptions();if(!this.hasViewableData)return!1;var a=this,c,f=a.getPos();n&&(a.shadowList.css("height","auto"),250<a.shadowList.height()&&a.shadowList.css("height",220));a.shadowList.css(f).addClass("datalist-visible");a.isListVisible=!0;
b(k).unbind(".datalist"+a.id).bind("mousedown.datalist"+a.id+" focusin.datalist"+a.id,function(c){c.target===a.input||a.shadowList[0]===c.target||b.contains(a.shadowList[0],c.target)?(clearTimeout(a.hideTimer),setTimeout(function(){clearTimeout(a.hideTimer)},9)):a.timedHide()});b(d).unbind(".datalist"+a.id).bind("resize.datalist"+a.id,function(){clearTimeout(c);c=setTimeout(function(){a.shadowList.css(a.getPos())},9)});return!0},hideList:function(){if(!this.isListVisible)return!1;var a=this,e=function(){a.changedValue&&
b(a.input).trigger("change");a.changedValue=!1};a.shadowList.removeClass("datalist-visible list-item-active").scrollTop(0).find("li.active-item").removeClass("active-item");a.index=-1;a.isListVisible=!1;if(a.changedValue){a.triggeredByDatalist=!0;c.triggerInlineForm&&c.triggerInlineForm(a.input,"input");if(a.input==k.activeElement||b(a.input).is(":focus"))b(a.input).one("blur",e);else e();a.triggeredByDatalist=!1}b(k).unbind(".datalist"+a.id);b(d).unbind(".datalist"+a.id);return!0},scrollIntoView:function(a){var c=
b("> ul",this.shadowList),d=a.position();d.top-=(parseInt(c.css("paddingTop"),10)||0)+(parseInt(c.css("marginTop"),10)||0)+(parseInt(c.css("borderTopWidth"),10)||0);0>d.top?this.shadowList.scrollTop(this.shadowList.scrollTop()+d.top-2):(d.top+=a.outerHeight(),a=this.shadowList.height(),d.top>a&&this.shadowList.scrollTop(this.shadowList.scrollTop()+(d.top-a)+2))},changeValue:function(a){if(a[0]){var a=b("span.option-value",a).text(),c=b.prop(this.input,"value");if(a!=c)b(this.input).prop("value",a).triggerHandler("updateInput"),
this.changedValue=!0}},markItem:function(a,c,d){d=d||b("li:not(.hidden-item)",this.shadowList);if(d.length)0>a?a=d.length-1:a>=d.length&&(a=0),d.removeClass("active-item"),this.shadowList.addClass("list-item-active"),d=d.filter(":eq("+a+")").addClass("active-item"),c&&(this.changeValue(d),this.scrollIntoView(d)),this.index=a}};(function(){c.defineNodeNameProperty("datalist","options",{prop:{writeable:!1,get:function(){var a=b("select",this);return a[0]?a[0].options:[]}}});c.defineNodeNameProperties("input",
{selectedOption:{prop:{writeable:!1,get:function(){var a=b.prop(this,"list"),c=null,d;if(!a)return c;d=b.attr(this,"value");if(!d)return c;a=b.prop(a,"options");if(!a.length)return c;b.each(a,function(a,e){if(d==b.prop(e,"value"))return c=e,!1});return c}}},autocomplete:{attr:{get:function(){var a=b.data(this,"datalistWidget");return a?a._autocomplete:"autocomplete"in this?this.autocomplete:this.getAttribute("autocomplete")},set:function(a){var c=b.data(this,"datalistWidget");c?(c._autocomplete=a,
"off"==a&&c.hideList()):"autocomplete"in this?this.autocomplete=a:this.setAttribute("autocomplete",a)}}},list:{attr:{get:function(){var a=c.contentAttr(this,"list");return null==a?p:a},set:function(a){c.contentAttr(this,"list",a);c.objectCreate(r,p,{input:this,id:a,datalist:b.prop(this,"list")})}},initAttr:!0,reflect:!0,propType:"element",propNodeName:"datalist"}});if(b.event.customEvent)b.event.customEvent.updateDatalist=!0,b.event.customEvent.updateInput=!0;c.addReady(function(a,c){c.filter("select, option").each(function(){var a=
this.parentNode,c=b.nodeName(a,"datalist");if(a&&!c)a=a.parentNode,c=b.nodeName(a,"datalist");a&&c&&b(a).triggerHandler("updateDatalist")})})})()}})()});

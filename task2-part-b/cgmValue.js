/**
 * Part B
 *
 * This is a simple value object.
 *
 * @param {string} name The name of the value object
 * @param {*} initialValue The initial value of the value object
 *
 * @todo Optimize the code below, dont change the signatures or the bevaiour
 * @todo Improve the setters to ensure that only a boolean value will be stored
 *       in the private attributes.(false, 0, null, undefined to be false)
 *
 *       Alternativly you can ensure that only true will be stored directly any
 *       other value should be false.
 *
 * @bonus Explain how we return an anonymous object. What are the pros and cons?
 *  ==> Anonymous Object :
 *  Pros :
 *  1. If all object that we develop are anonymous the size of file could be more light.
 *  2. If anonymous function is affected to a variable , the code can be still readable by a new developer
 *
 *  Cons :
 *  1. It may be unreadable if every object a anonymous
 *   So it could be difficult to understand the code for a developer who has no functional background
 */
/*function CgmValue(name, initialValue) {
 var _enabled = false;
 var _visible = false;

 var _name = name;
 var _value = initialValue;

 return {
 getName: function() {
 return _enabled === true && _visible === true ? _name : null;
 },
 getValue: function() {
 return _enabled === true && _visible === true ? _value : null;
 },
 setEnabled: function(enabled) {
 _enabled = enabled;
 },
 setVisible: function(visible) {
 _visible = visible;
 }
 };
 }*/

function CgmValue(name, initialValue) {

    CgmValueClass = function (name, initialValue) {
        this._enabled = false;
        this._visible = false;

        this._name = name;
        this._value = initialValue;
    };


    CgmValueClass.prototype.getName = function () {
        return _enabled === true && _visible === true ? _name : null;
    };

    CgmValueClass.prototype.getValue = function () {
        return _enabled === true && _visible === true ? _value : null;
    };

    CgmValueClass.prototype.setEnabled = function (enabled) {
        this._enabled = _getBoolean(enabled);
    };

    CgmValueClass.prototype.setVisible = function (visible) {
        this._visible = _getBoolean(visible);
    };

    /**
     * Does the item is valid
     * @param item the item to process
     * @returns {boolean} True if item is a boolean
     * @private
     */
    function _getBoolean(item) {
        return typeof item === 'boolean' && item === true;
    }


    return new CgmValueClass(name, initialValue);
}
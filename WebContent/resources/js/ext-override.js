(function() {
	top.resetTimer();
})();

Ext.override(Ext.data.Connection, {
	request: function() {
		top.resetTimer();
		return this.callOverridden(arguments);
	}
});
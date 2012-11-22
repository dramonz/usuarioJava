//<!-- Begin
	// Take user here after session timed out
	timedouturl = "j_spring_security_logout";

	function Minutes(data) {
		for (var i = 0; i < data.length; i++)
		if (data.substring(i, i + 1) == ":")
			break;
		return (data.substring(0, i));
	}
	function Seconds(data) {
		for (var i = 0; i < data.length; i++)
		if (data.substring(i, i + 1) == ":")
			break;
		return (data.substring(i + 1, data.length));
	}
	function Display(min, sec) {
	var disp;
	if (min <= 9) disp = " 0";
	else disp = " ";
	disp += min + ":";
	if (sec <= 9) disp += "0" + sec;
	else disp += sec; 
	return (disp);
	}
	function Down() { 
	sec--;      
	if (sec == -1) { sec = 59; min--; }
		document.timerform.timerSession.value = Display(min, sec);
		window.status = "Session will time out in: " + Display(min, sec);
	if (min == 0 && sec == 0) {
		alert('La sesi\u00F3n ha expirado por inactividad.');
		window.location.href = timedouturl;
	}
	else down = setTimeout("Down()", 1000);
	}
	function timeIt() {
		if (document.timerform.originalmin.value != '') {
			document.timerform.timerSession.value = Display(document.timerform.originalmin.value, document.timerform.originalsec.value);
		}
		
		min = 1 * Minutes(document.timerform.timerSession.value);
		originalMin = min;
		document.timerform.originalmin.value = originalMin;
		sec = 0 + Seconds(document.timerform.timerSession.value);
		originalSec = sec;
		document.timerform.originalsec.value = originalSec;
		Down();
	}
	
	function resetTimer() {
		document.timerform.timerSession.value = Display(originalMin, originalSec);
		min = originalMin;
		sec = originalSec;
//		Down();
	}
	//  End -->
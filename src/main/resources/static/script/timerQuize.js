function checklength(i) {
    if (i < 10) {
        i = "0" + i;
    }
    return i;
}
var minutes, seconds, count, counter, timer;
count = 60 * 5;
counter = setInterval(timer, 1000);
function timer() {
    'use strict';
    count = count - 1;
    minutes = checklength(Math.floor(count / 60));
    seconds = checklength(count - minutes * 60);
    if (count < 0) {
        clearInterval(counter);
        return;
    }
    // document.getElementById("timer").innerHTML = 'Kuizi do të përfundoj mbrenda ' + minutes + ':' + seconds + ' minutave !';
    document.getElementById("timer").innerHTML =minutes + ':' + seconds;
    if (count === 0) {
        // location.reload();
        document.getElementById("pyetjaForm").submit();
    }
}
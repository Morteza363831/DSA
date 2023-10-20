export function solver(n = 16) {
	var binery = "";
	var x = n;
	while(true) {
	    x = x/2;
	    if (x%2 === 0) {
	        binery =  1 + "" ;
	    }
	    else if (x%2 !== 0) {
	        binery = "0" + binery ;
	    }
        if (x === 0) {
            break;
        }
	}
	return binery ;
}
## go to copy files faster
## what the project is of
- direct copy program uses built in `os.CopyFS`
- go routine copy program uses custom copying which uses go routines and wait groups
## the effect
- i copied my music foler using both go programs
- the direct copy took around 760 milli seconds
- the go routine copy took around 215 milli seconds
## how it works 
- the `callCopyDirByCmd` takes the to be copied directory name from arguments
- before and after the function call we take the time and log the difference
- we create a wait group and call `copyDir`
- we wait until the routine finishes by wait in main routine
- we pass the waitgroup reference to the the   `copyDir` function
- in defer call we call `wg.done`(defer can say a cleanup function (like finally block))
- we read items inside the directory
- for each item we create a new waitgroup
- if the item is directory we recursivly call the copyDir
- each copyDir waits until it finishes
- if it is file ,it copies the file by io.copy

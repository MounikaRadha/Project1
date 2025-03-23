import EndPointCreationComponent from "./EndPointCreationComponent";
import EndPointListViewComponent from "./EndPointListViewComponent"
import EndPointService from "./EndPointService"

const EndPointComponent=()=>{
    const endPointsList=EndPointService.useFindAllEndPoints();
return (<>
<p>endpoint component</p>
<EndPointListViewComponent endPointsList={endPointsList}/>
<EndPointCreationComponent/>
</>)
}
export default EndPointComponent
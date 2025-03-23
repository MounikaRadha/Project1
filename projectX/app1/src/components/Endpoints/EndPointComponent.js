import EndPointCreationComponent from "./EndPointCreationComponent";
import EndPointListViewComponent from "./EndPointListViewComponent";
import EndPointService from "./EndPointService";
import "../../styles/Common.css";

const EndPointComponent = () => {
  const endPointsList = EndPointService.useFindAllEndPoints();

  return (
    <div className="my-container">
      <div className="creation-section">
        <EndPointCreationComponent />
      </div>
      <div className="list-section">
        <EndPointListViewComponent endPointsList={endPointsList} />
      </div>
    </div>
  );
};

export default EndPointComponent;

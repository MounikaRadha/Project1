import NoDataInDb from "../NoDataInDb";
import "../../styles/ListViewComponent.css";

const EndPointListViewComponent = ({ endPointsList = [] }) => {
  return (
    <div className="my-list-container">
      <h2 className="my-header">Endpoint List</h2>
      {endPointsList.length > 0 ? (
        endPointsList.map((endpoint, index) => (
          <EndPointItem key={index} endPointItem={endpoint} />
        ))
      ) : (
        <NoDataInDb modalType={"End point"} />
      )}
    </div>
  );
};

export default EndPointListViewComponent;

export const EndPointItem = ({ endPointItem }) => {
  return (
    <div className="my-card">
      <p className="my-label">
        <span className="label">Endpoint:</span> {endPointItem?.endPoint}
      </p>
    </div>
  );
};

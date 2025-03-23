import NoDataInDb from "../NoDataInDb";
import "../../styles/ListViewComponent.css";
import URL_Constants from "../../constants/Url_Constants";

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
        <span className="label">Endpoint id: {endPointItem?.id}</span>
      </p>
      <p className="my-label">
        <a href={URL_Constants.BASE_NAME+URL_Constants.POSTED_DATA_PATH+"?endPointId="+endPointItem?.id}>
        <span className="label">Endpoint:</span> {endPointItem?.endPoint}
        </a>
      </p>
    </div>
  );
};

import NoDataInDb from '../NoDataInDb';


const EndPointListViewComponent = ({ endPointsList = [] }) => {
  return (
    <div className="list-container">
      <h2>Endpoint List</h2>
      {endPointsList.length > 0 ? (
        endPointsList.map((endpoint, index) => <EndPointItem key={index} endPointItem={endpoint} />)
      ) : (
        <NoDataInDb modalType={"End point"} />
      )}
    </div>
  );
};

export default EndPointListViewComponent;

export const EndPointItem = ({ endPointItem }) => {
  return (
    <div className="endpoint-item">
      <p><strong>Endpoint:</strong> {endPointItem?.["endPoint"]}</p>
    </div>
  );
};

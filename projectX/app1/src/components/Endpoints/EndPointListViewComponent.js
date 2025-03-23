const EndPointListViewComponent = ({ endPointsList = [] }) => {
  return (
    <>
      endpoint list view component
      {endPointsList.length > 0 ? (
        endPointsList?.map((endpoint) => <p>{endpoint["endPoint"]}</p>)
      ) : (
        <p>no endpoints</p>
      )}
    </>
  );
};
export default EndPointListViewComponent;

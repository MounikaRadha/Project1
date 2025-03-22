const EndPointListViewComponent = ({ endPointsList = [] }) => {
  return (
    <>
      endpoint list view component
      {endPointsList.length > 0 ? (
        endPointsList?.map((endpoint) => <p>{endpoint?.id}</p>)
      ) : (
        <p>no endpoints</p>
      )}
    </>
  );
};
export default EndPointListViewComponent;

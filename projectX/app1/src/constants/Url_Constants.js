const BACKEND_URL = "http://localhost:9898";
const BASE_NAME="/ui"
const BASE_URL = BACKEND_URL + "/private/the_updater/v1";
const USERS_PATH= "/users"
const USERS = BASE_URL +USERS_PATH;
const END_POINTS_PATH="/end_points"
const END_POINTS = BASE_URL + END_POINTS_PATH;
const POSTED_DATA_PATH="/post_data"
const POSTED_DATA = BASE_URL + POSTED_DATA_PATH;
const URL_Constants = { BACKEND_URL, BASE_URL, USERS, END_POINTS, POSTED_DATA ,BASE_NAME,USERS_PATH,END_POINTS_PATH,POSTED_DATA_PATH};
export default URL_Constants;

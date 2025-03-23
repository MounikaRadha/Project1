import URL_Constants from "../../constants/Url_Constants";
import "./Navbar.css"; // Import CSS file

const Navbar = () => {
    return (
        <nav className="navbar">
            <a href={URL_Constants.BASE_NAME} className="nav-link">Home</a>
            <a href={URL_Constants.BASE_NAME + URL_Constants.USERS_PATH} className="nav-link">Users</a>
            <a href={URL_Constants.BASE_NAME + URL_Constants.END_POINTS_PATH} className="nav-link">Endpoint</a>
            <a href={URL_Constants.BASE_NAME + URL_Constants.POSTED_DATA_PATH} className="nav-link">Posted Data</a>
            <a href={URL_Constants.BASE_NAME + "/counter"} className="nav-link">Counter</a>
            
        </nav>
    );
};

export default Navbar;

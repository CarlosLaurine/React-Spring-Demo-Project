import Footer from "components/Footer";
import NavBar from "components/NavBar";
import { Link } from "react-router-dom";

const Home = () => {
    return (
        <>
        <NavBar/>
        <div className="container">
            <div className="jumbotron">
                <h1 className="display-4">DSSales</h1>
                <p className="lead">Analyze your Sales Development from Different Perspectives</p>
                <hr />
                <p>This Application consists of displaying a Dashboard built with React/TypeScript/Bootstrap fulfilled with Data provided by a Back End built with Spring Boot and Stored at a Postgres Database (pgAdmin 4)</p>
                <Link className="btn btn-large btn-primary" to="/dashboard">
                    Access Dashboard
                </Link>
            </div>
        </div>
        <Footer/>
        </>
    );
}

export default Home;
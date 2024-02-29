import React from 'react';
import NavBar from '../../Components/navbarComponent/NavBarPage';
import Footer from '../../Components/footerComponent/FooterPage';
import GrafanaDashboard from '../../Components/grafanaDashboardComponent/grafanaDashboard'

const Home = () => {
  return (
    <div>
      <div>
        <NavBar />
          <GrafanaDashboard />
        <Footer />
      </div>
    </div>
  );
};

export default Home;

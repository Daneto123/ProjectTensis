import React from 'react';
import './styles.css'

const Footer = () => {
  return (
    <footer>
      <div class="footer">
        {/* <div class="row">
          <a id="icon" href="https://www.facebook.com/"><FontAwesomeIcon icon={faFacebook} /></a>
          <a id="icon" href="https://www.instagram.com/"><FontAwesomeIcon icon={faInstagram} /></a>
          <a id="icon" href="https://www.youtube.com/watch?v=VzUUYpvvyYw"><FontAwesomeIcon icon={faYoutube} /></a>
          <a id="icon" href="https://twitter.com/"><FontAwesomeIcon icon={faTwitter} /></a>
        </div> */}
          
          <div class="row">
          <ul>
          <li><a href="#">About us</a></li>
          <li><a href="/">Add Sensor</a></li>
          <li><a href="https://www.techtarget.com/iotagenda/definition/Internet-of-Things-privacy-IoT-privacy">Privacy Policy</a></li>
          <li><a href="#">Terms & Conditions</a></li>
          </ul>
          </div>
          
          <div class="row">
            <a href='#'>IoT app with rapberry app</a> 
        </div>
      </div>
    </footer>
  );
};

export default Footer;

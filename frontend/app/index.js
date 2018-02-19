const React = require('react');
const ReactDOM = require('react-dom');
import Layout from './modules/Layout';


$(document).ready(function() {
	ReactDOM.render(
		<Layout />,
		document.getElementById('main_container')
	);
});


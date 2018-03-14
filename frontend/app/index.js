const React = require('react');
const ReactDOM = require('react-dom');
import Layout from './modules/Layout';


$(document).ready(function() {
	ReactDOM.render(
		<Layout />,
		document.getElementById('main_container')
	);

	fetch('http://localhost:8181/event/getAllPreview', {
		method: 'GET',
        mode: 'cors',
	}).then(function (res) {
		console.log(res);
    })
});


const React = require('react');
const ReactDOM = require('react-dom');
import moment from 'moment';
import Layout from './modules/Layout/index';


$(document).ready(function() {
	moment.locale('ru');
	ReactDOM.render(
		<Layout />,
		document.getElementById('main_container')
	);
});


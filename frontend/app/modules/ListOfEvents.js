const React = require('react');
const ListItem = require('./ListItem');

class ListOfEvents extends React.Component {


	render () {
		let events = this.props.events.map((item) => {
			return (
				<ListItem onClick={this.props.onClick} dataId={item.id} key={item.id}>{item.name}</ListItem>
			);
		});

		return (
			<div>
				<ul>
					{ events }
				</ul>
			</div>
		);
	}
}

module.exports = ListOfEvents;
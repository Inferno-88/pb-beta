const React = require('react');
const ListOfEvents = require('./ListOfEvents');
const EventDescription = require('./EventDescription');

class Layout extends React.Component {
	constructor (props) {
		super(props);
		this.state = {
			currentEvent: null,
		};
		this.events = [{
			name: 'game1',
			id: '0'
		}, {
			name: 'game2',
			id: '2'
		}];

		this.detailEvent=[{
			id:0,
			description: 'greate Event',
		},{},{
			id:2,
			description: 'GOOOoooood',
		}];
	}

	hendlerOpenEvent (e) {
		const discr = this.detailEvent[e.target.dataset.id];
		this.setState({
			currentEvent: discr,
		});
	}

	render () {
		return (
			<div>
				<ListOfEvents events={this.events} onClick={this.hendlerOpenEvent.bind(this)} />
				<EventDescription event={this.state.currentEvent} />
			</div>
		);
	}
}

module.exports = Layout;

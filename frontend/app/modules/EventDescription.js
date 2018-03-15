const React = require('react');


class EventDescription extends React.Component {


	render () {
		const ev = JSON.stringify(this.props.event);

		return (
			<div>
				{ev}
			</div>
		);
	}
}

module.exports = EventDescription;
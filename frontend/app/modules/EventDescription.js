const React = require('react');


class EventDescription extends React.Component {


	render () {
		const ev = this.props.event ? this.props.event.description : '' ;

		return (
			<div>
				{ev}
			</div>
		);
	}
}

module.exports = EventDescription;
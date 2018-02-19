const React = require('react');

class ListItem extends React.Component {

	render () {
		return (
			<li onClick={this.props.onClick} className='list_item' data-id={this.props.dataId}>
				{this.props.children}
			</li>
		);
	}
}

module.exports = ListItem;

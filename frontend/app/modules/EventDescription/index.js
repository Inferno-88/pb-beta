import React from 'react';
import style from './style.css';
import EventHeader from './EventHeader/index';

import ImageGallery from 'react-image-gallery';
import '!style-loader!css-loader!react-image-gallery/styles/css/image-gallery.css';

import { imagesOfEvent } from '../../mockdata';


class EventDescription extends React.Component {


	render () {
		const ev = this.props.event;
		let classNames = `${style.eventDescription} ${this.props.className}`;

		const images = imagesOfEvent.map((image) => {
			return {
				original: image,
				thumbnail: image,
			};
		});

		return (
			<div className={classNames}>
				<div className={style.header}>
					<EventHeader
						name={ev.name}
						beginDate={ev.beginDate}
						endDate={ev.endDate}
						capacity={ev.capacity}
					/>
				</div>
				<div className={style.main}>
					<div className={style.gallery}>
						<ImageGallery items={images} />
					</div>
					<div className={style.info}>
						<EventInfoTable
							info={ev.info}
							field={ev.field}
							gameRules={ev.gameRules}
						/>
					</div>
				</div>
				<div className={style.playersArea}>
					{JSON.stringify(ev.groupMap)}
				</div>

			</div>
		);
	}
}

export default EventDescription;
<template>
    <div class="main-map" ref="map">
        <div>
            <h4> 
                address : {{ currAddr }}
            </h4>
        </div>
    </div>
</template>

<script>
import OlLayerTile from 'ol/layer/Tile'
import OlView from 'ol/View'
import OlMap from 'ol/Map'
import OSM from 'ol/source/OSM'
import {fromLonLat, toLonLat} from 'ol/proj'
import {defaults} from 'ol/control'
import axios from 'axios'

export default {
    name: 'MainMap',
    data() {
        return {
            olMap: undefined,
            currAddr: undefined
        }
    },
    mounted() {
        this.olMap = new OlMap({
            target: this.$refs.map,
            controls: defaults({
                attribution: false,
                zoom: false,
                rotate: false,
            }),
            layers: [
                new OlLayerTile({
                    source: new OSM()
                })
            ],
            view: new OlView({
                center: fromLonLat([127.1388684, 37.4449168]),
                zoom: 10
            })
        })

        this.olMap.on('click', async (e) => {
            const [lon, lat] = toLonLat(e.coordinate);
            const addressInfo = await this.getAddress(lon, lat);

            //console.log(addressInfo)
            this.currAddr = addressInfo.data.display_name;
        })
    },
    methods: {
        getUiAddress(str) {
            return str.split(', ').reverse().join(' ');
        },
        getAddress(lon, lat) {
            return axios.get('https://nominatim.openstreetmap.org/reverse', {
                params: {
                    format: 'json',
                    lon: lon,
                    lat: lat,
                },
            });
        }
    }
}
</script>

<style scoped>
.main-map {
    width: 100%;
    height: 100%;
}

</style>
package ru.advantum.voicegenerator.voicekit.response;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import ru.advantum.voicegenerator.voicekit.utils.Printer;
import tinkoff.cloud.stt.v1.Stt;

public class SttStreamingRecognizeHandler extends BaseHandler<Stt.StreamingRecognizeResponse> {

    @Override
    public void onNext(Stt.StreamingRecognizeResponse value) {
        try {
            Printer.getPrinter().println(JsonFormat.printer().print(value));
        } catch (InvalidProtocolBufferException e) {
            onError(e);
        }
    }
}
